package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "User creation request model", value = "User creation request")
public class UserDataDTO {

    @ApiModelProperty(position = 1, required = true)
    private String name;

    @ApiModelProperty(position = 2)
    private String surname;

    @ApiModelProperty(position = 3)
    private String email;

    @ApiModelProperty(position = 4, required = true)
    private String username;

    @ApiModelProperty(position = 5)
    private Integer clientId;

    @ApiModelProperty(position = 6, required = true)
    private String password;

    @ApiModelProperty(position = 7, required = true)
    private Integer status;

}