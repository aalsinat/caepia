package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "User information")
public class UserResponseDTO {

	@ApiModelProperty()
	private String username;

	@ApiModelProperty(position = 1)
	private Integer status;

	@ApiModelProperty(position = 2)
	private Integer clientId;

}