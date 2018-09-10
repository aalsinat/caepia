package com.caepia.app.api.model.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@RequiredArgsConstructor
public class Permission implements GrantedAuthority {
    @JsonIgnore
    private final ApplicationPermision permission;

    @Override
    public String getAuthority() {
        return String.format("%s_%s", permission.getProfile(), permission.getActions());
    }
}
