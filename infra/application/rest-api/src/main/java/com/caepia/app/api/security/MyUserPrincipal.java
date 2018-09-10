package com.caepia.app.api.security;

import com.caepia.app.api.model.authentication.Permission;
import com.caepia.app.api.model.domain.UserApplicationDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserPrincipal implements UserDetails {
    private UserApplicationDetails user;

    public MyUserPrincipal(UserApplicationDetails user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.user.getPermissions().stream()
                        .map(permit -> new Permission(permit.getProfile(), permit.getActions()))
                        .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
