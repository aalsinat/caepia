package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "LoginResponse", description = "Successful response model")
public class LoginResponseDTO {
	private String token;

	public LoginResponseDTO() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
