package com.caepia.app.api.dto;

import com.caepia.app.api.model.domain.UserCenter;
import com.caepia.app.api.model.domain.UserParameter;
import com.caepia.app.api.model.domain.UserPermission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
@ApiModel(value = "LoginResponse", description = "Successful response model")
public class LoginResponseDTO {
    @ApiModelProperty
    private String token;

    @ApiModelProperty
    private Collection<UserCenter> centers;

    @ApiModelProperty
    private Collection<UserPermission> permissions;

    @ApiModelProperty
    private Collection<UserParameter> parameters;
}
