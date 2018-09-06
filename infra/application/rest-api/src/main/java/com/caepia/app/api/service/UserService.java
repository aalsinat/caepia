package com.caepia.app.api.service;

import com.caepia.app.api.exception.CustomException;
import com.caepia.app.api.model.authentication.DatabaseUser;
import com.caepia.app.api.model.authentication.Role;
import com.caepia.app.api.repository.authentication.UserRepository;
import com.caepia.app.api.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(String username, String password) {
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);


        return jwtTokenProvider.createToken(username);
    }

    public String signup(DatabaseUser databaseUser) {
        if (!userRepository.existsByUsername(databaseUser.getUsername())) {
            databaseUser.setPassword(passwordEncoder.encode(databaseUser.getPassword()));
            userRepository.save(databaseUser);
            //return jwtTokenProvider.createToken(databaseUser.getUsername(), databaseUser.getRoles());
            return jwtTokenProvider.createToken(databaseUser.getUsername());
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