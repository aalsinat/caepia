package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "DeliveryNotes row request information", value = "DeliveryRowPutData")
@Getter
public class DeliveryNoteRowPutDataDTO {

    @ApiModelProperty(position = 1)
    private Float docPackQuantity;

    @ApiModelProperty(position = 2)
    private String comments;

    public String getComments() {
        return this.comments == null ? "" : this.comments;

    }


}

