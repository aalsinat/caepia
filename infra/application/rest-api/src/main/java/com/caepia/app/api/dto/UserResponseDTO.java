package com.caepia.app.api.dto;

import com.caepia.app.api.model.Role;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserResponseDTO {

//	@ApiModelProperty(position = 2)
//	List<Role> roles;

	@ApiModelProperty(position = 0)
	private String id;

	@ApiModelProperty(position = 1)
	private String username;

	@ApiModelProperty(position = 2)
	private Integer status;

	@ApiModelProperty(position = 3)
	private Integer clientId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

}