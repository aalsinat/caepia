package com.caepia.app.api.repository.authentication;

import com.caepia.app.api.dto.LoginResult;

public interface UserAuthenticationRepository {
	LoginResult signin(String username, String password, Integer version);
}
