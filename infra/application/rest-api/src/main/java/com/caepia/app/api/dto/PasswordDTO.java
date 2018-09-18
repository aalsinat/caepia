package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "New password request model", value = "New password request")
public class PasswordDTO {
    @ApiModelProperty
    private String password;
}
