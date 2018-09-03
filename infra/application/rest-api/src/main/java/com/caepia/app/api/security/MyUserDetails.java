package com.caepia.app.api.security;

import com.caepia.app.api.model.DatabaseUser;
import com.caepia.app.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetails implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final DatabaseUser databaseUser = userRepository.findByUsername(username);

		if (databaseUser == null) {
			throw new UsernameNotFoundException("DatabaseUser '" + username + "' not found");
		}

		return org.springframework.security.core.userdetails.User//
		                                                         .withUsername(username)//
		                                                         .password(databaseUser.getPassword())//
		                                                         //.authorities(databaseUser.getRoles())//
		                                                         .accountExpired(false)//
		                                                         .accountLocked(false)//
		                                                         .credentialsExpired(false)//
		                                                         .disabled(false)//
		                                                         .build();
	}

}