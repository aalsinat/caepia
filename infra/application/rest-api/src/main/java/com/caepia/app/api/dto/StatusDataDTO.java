package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "Status request information", value = "ProductionOrderData")
@Getter
public class StatusDataDTO {
    @ApiModelProperty(position = 1, required = true)
    private Integer status;

}
