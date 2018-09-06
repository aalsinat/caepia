package com.caepia.app.api.security;

import com.caepia.app.api.dto.LoginResult;
import com.caepia.app.api.exception.NotExistingUserException;
import com.caepia.app.api.model.authentication.Role;
import com.caepia.app.api.repository.authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class CustomAuthenticationProvider { //implements AuthenticationProvider {
//	@Autowired
//	UserRepository repository;
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		final String name = authentication.getName();
//		final String password = authentication.getCredentials().toString();
//
//		LoginResult loginResult = repository.signin(name, password, 1);
//		System.out
//				.println("username = [" + name + "], password = [" + password + "]" + "-> status = [" + loginResult + "]");
//
//		if (loginResult.getErrorCode() != 0) throw new NotExistingUserException("Username does not exist");
//
//		return new UsernamePasswordAuthenticationToken(name, password, Arrays.asList(Role.ROLE_ADMIN));
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
}
