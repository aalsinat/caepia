package com.caepia.app.api.service;

import com.caepia.app.api.exception.CustomException;
import com.caepia.app.api.model.authentication.DatabaseUser;
import com.caepia.app.api.repository.authentication.UserRepository;
import com.caepia.app.api.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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
		try {
			DatabaseUser user = userRepository.findByUsername(username);
			System.out.println("username = [" + user.getUsername() + "], password = [" + this.passwordEncoder
					.matches(password, user.getPassword()) + "]");

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));//, Arrays.asList(Role.ROLE_ADMIN)));

			return jwtTokenProvider.createToken(username);
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
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