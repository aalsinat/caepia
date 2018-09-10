package com.caepia.app.api.service.authentication;

import com.caepia.app.api.dto.LoginResponseDTO;
import com.caepia.app.api.exception.CustomException;
import com.caepia.app.api.model.authentication.UserAccount;
import com.caepia.app.api.model.domain.UserInfo;
import com.caepia.app.api.repository.authentication.UserAccountRepository;
import com.caepia.app.api.repository.domain.UserInfoRepository;
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
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

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

        final UserInfo userInfo = userInfoRepository.findByUsername(username);

        return LoginResponseDTO.builder().token(jwtTokenProvider.createToken(username))
                               .centers(userInfo.getCenters())
                               .permissions(userInfo.getPermissions())
                               .parameters(userInfo.getParameters()).build();

    }

    public String signup(UserAccount userAccount) {
        if (!userAccountRepository.existsByUsername(userAccount.getName())) {
            userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
            userAccountRepository.save(userAccount);
            //return jwtTokenProvider.createToken(userAccount.getName(), userAccount.getRoles());
            return jwtTokenProvider.createToken(userAccount.getName());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userAccountRepository.deleteByUsername(username);
    }

    public UserAccount search(String username) {
        UserAccount userAccount = userAccountRepository.findByUsername(username);
        if (userAccount == null) {
            throw new CustomException("The userAccount doesn't exist", HttpStatus.NOT_FOUND);
        }
        return userAccount;
    }

    public UserAccount whoami(HttpServletRequest req) {
        return userAccountRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

}