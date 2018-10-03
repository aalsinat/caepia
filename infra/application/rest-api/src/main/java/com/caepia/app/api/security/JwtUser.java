package com.caepia.app.api.security;

import com.caepia.app.api.model.authentication.Permission;
import com.caepia.app.api.model.domain.UserCenter;
import com.caepia.app.api.model.domain.UserParameter;
import com.caepia.app.api.model.domain.UserPermission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class JwtUser implements UserDetails {
    private String username;
    private String name;
    @JsonIgnore
    private String surname;
    private String password;
    private String email;
    private Collection<UserCenter> centers;
    private Collection<UserParameter> parameters;
    private Collection<UserPermission> permissions;

    public String getName() {
        return String.format("%s, %s", name, surname);
    }


    public List<String> getParameters() {
        return this.parameters.stream().map(UserParameter::getParamId).collect(Collectors.toList());
    }

    public List<String> getPermissions() {
        return this.permissions.stream().map(Permission::new).map(Permission::getAuthority)
                               .collect(Collectors.toList());
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions.stream().map(Permission::new).collect(Collectors.toList());
    }


    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
