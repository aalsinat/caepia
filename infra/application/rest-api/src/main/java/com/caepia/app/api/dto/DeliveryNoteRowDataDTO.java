package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "Order row request information", value = "DeliveryRowData")
@Getter
public class DeliveryNoteRowDataDTO {

    @ApiModelProperty(position = 1)
    private Integer deliveryNoteId;

    @ApiModelProperty(position = 2)
    private String productName;

    @ApiModelProperty(position = 3)
    private Integer categoryL3;

    @ApiModelProperty(position = 4)
    private Integer units;

    @ApiModelProperty(position = 5)
    private Float packQuantity;

    @ApiModelProperty(position = 6)
    private Float cost;

    @ApiModelProperty(position = 7)
    private String comments;

    public String getComments() {
        return this.comments == null ? "" : this.comments;

    }


}

