package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User creation request model", value = "User creation request")
public class UserDataDTO {

//	@ApiModelProperty(position = 2)
//	List<Role> roles;

	@ApiModelProperty()
	private String id;

	@ApiModelProperty(position = 1)
	private String username;


	@ApiModelProperty(position = 2)
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