package com.caepia.app.api.model.authentication;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@RequiredArgsConstructor
public class Permission implements GrantedAuthority {
    private final String profile;
    private final String action;
    private final String PATTERN = "%s_%s";

    @Override
    public String getAuthority() {
        return String.format(PATTERN, profile, action);
    }
}
