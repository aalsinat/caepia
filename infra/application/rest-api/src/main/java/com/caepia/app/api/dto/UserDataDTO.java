package com.caepia.app.api.dto;

import com.caepia.app.api.model.Role;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserDataDTO {

	@ApiModelProperty(position = 2)
	List<Role> roles;
	@ApiModelProperty(position = 0)
	private String username;
	@ApiModelProperty(position = 1)
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}