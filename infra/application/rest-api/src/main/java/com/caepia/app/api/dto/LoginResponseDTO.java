package com.caepia.app.api.dto;

import com.caepia.app.api.model.domain.UserApplicationCenter;
import com.caepia.app.api.model.domain.UserApplicationParameter;
import com.caepia.app.api.model.domain.UserApplicationPermission;
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
    private Collection<UserApplicationCenter> centers;

    @ApiModelProperty
    private Collection<UserApplicationPermission> permissions;

    @ApiModelProperty
    private Collection<UserApplicationParameter> parameters;
}
