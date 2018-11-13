package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "Delivert Note header request information", value = "DeliveryNoteHeaderData")
@Getter
public class DeliveryNoteHeaderDataDTO {
    @ApiModelProperty(position = 1, required = true)
    private Integer costCenter;

    @ApiModelProperty(position = 2, required = true)
    private String deliveryNoteDate;

    @ApiModelProperty(position = 3, required = true)
    private Integer vendor;

    @ApiModelProperty(position = 4, required = true)
    private String vendorNumDoc;

    @ApiModelProperty(position = 5, required = true)
    private String vendorDate;

    @ApiModelProperty(position = 6)
    private String comments;

    public String getComments() {
        return this.comments == null ? "" : this.comments;

    }


}