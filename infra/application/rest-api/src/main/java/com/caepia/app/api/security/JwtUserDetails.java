package com.caepia.app.api.security;

import com.caepia.app.api.model.authentication.UserAccount;
import com.caepia.app.api.model.domain.UserInfo;
import com.caepia.app.api.repository.authentication.UserAccountRepository;
import com.caepia.app.api.repository.domain.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserAccount userAccount = userAccountRepository.findByUsername(username);
        final UserInfo userInfo = userInfoRepository.findByUsername(username);

        if (userAccount == null) {
            throw new UsernameNotFoundException("UserAccount '" + username + "' not found");
        }
        return JwtUser.builder()
                      .username(userAccount.getUsername())
                      .password(userAccount.getPassword())
                      .userId(userInfo.getUserId())
                      .name(userAccount.getName())
                      //.surname(userInfo.getSurname())
                      .email(userInfo.getEmail())
                      .clientId(userAccount.getClientId())
                      .centers(userInfo.getCenters())
                      .parameters(userInfo.getParameters())
                      .permissions(userInfo.getPermissions())
                      .build();
    }
}