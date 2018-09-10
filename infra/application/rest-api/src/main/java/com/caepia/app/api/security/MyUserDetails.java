package com.caepia.app.api.security;

import com.caepia.app.api.model.authentication.DatabaseUser;
import com.caepia.app.api.model.authentication.Role;
import com.caepia.app.api.model.domain.UserApplicationDetails;
import com.caepia.app.api.repository.authentication.UserRepository;
import com.caepia.app.api.repository.domain.UserApplicationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserApplicationDetailsRepository userApplicationDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final DatabaseUser databaseUser = userRepository.findByUsername(username);
        final UserApplicationDetails userApplicationDetails = userApplicationDetailsRepository.findByLoginId(username);

        if (databaseUser == null) {
            throw new UsernameNotFoundException("DatabaseUser '" + username + "' not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(databaseUser.getPassword())
                .authorities(Arrays.asList(Role.ROLE_CLIENT))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }


}