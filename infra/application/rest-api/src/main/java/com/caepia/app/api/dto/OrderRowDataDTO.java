package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "Order row request information", value = "OrderRowData")
@Getter
public class OrderRowDataDTO {

    @ApiModelProperty(position = 1)
    private String productName;

    @ApiModelProperty(position = 2)
    private Integer categoryL3;

    @ApiModelProperty(position = 3)
    private Integer units;

    @ApiModelProperty(position = 4)
    private Float packQuantity;

    @ApiModelProperty(position = 5)
    private Float cost;

    @ApiModelProperty(position = 6)
    private String comments;

    public String getComments() {
        return this.comments == null ? "" : this.comments;

    }


}
