package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "log data request information", value = "LogData")
@Getter
public class LogDataDTO {
    @ApiModelProperty(position = 1, required = true)
    private Integer logProces;

    @ApiModelProperty(position = 2, required = true)
    private Integer logEventType;

    @ApiModelProperty(position = 3, required = true)
    private String description;

    @ApiModelProperty(position = 4, required = true)
    private String extraInfo;

    @ApiModelProperty(position = 5)
    private String deviceInfo;

    public String getDescription() {
        return this.description == null ? "" : this.description;

    }


}
