package com.caepia.app.api.service.authentication;

import com.caepia.app.api.dto.LoginResponseDTO;
import com.caepia.app.api.exception.CustomException;
import com.caepia.app.api.model.authentication.DatabaseUser;
import com.caepia.app.api.model.domain.UserApplicationDetails;
import com.caepia.app.api.repository.authentication.UserRepository;
import com.caepia.app.api.repository.domain.UserApplicationDetailsRepository;
import com.caepia.app.api.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserApplicationDetailsRepository userApplicationDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginResponseDTO signin(String username, String password) {
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserApplicationDetails userApplicationDetails = userApplicationDetailsRepository.findByLoginId(username);

        return LoginResponseDTO.builder().token(jwtTokenProvider.createToken(username))
                               .centers(userApplicationDetails.getCenters())
                               .permissions(userApplicationDetails.getPermissions())
                               .parameters(userApplicationDetails.getParameters()).build();

    }

    public String signup(DatabaseUser databaseUser) {
        if (!userRepository.existsByUsername(databaseUser.getName())) {
            databaseUser.setPassword(passwordEncoder.encode(databaseUser.getPassword()));
            userRepository.save(databaseUser);
            //return jwtTokenProvider.createToken(databaseUser.getName(), databaseUser.getRoles());
            return jwtTokenProvider.createToken(databaseUser.getName());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public DatabaseUser search(String username) {
        DatabaseUser databaseUser = userRepository.findByUsername(username);
        if (databaseUser == null) {
            throw new CustomException("The databaseUser doesn't exist", HttpStatus.NOT_FOUND);
        }
        return databaseUser;
    }

    public DatabaseUser whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

}