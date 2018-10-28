package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "Production Order request information", value = "OrderHeaderData")
@Getter
public class ProductionOrderRowDataDTO {
    @ApiModelProperty(position = 1, required = true)
    private Float quantity;

    @ApiModelProperty(position = 2)
    private String comments;

    public String getComments() {
        return this.comments == null ? "" : this.comments;

    }

}
