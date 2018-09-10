package com.caepia.app.api.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class JwtAuthenticationResponse implements Serializable {
    private final UserDetails user;
    private final String token;
}
