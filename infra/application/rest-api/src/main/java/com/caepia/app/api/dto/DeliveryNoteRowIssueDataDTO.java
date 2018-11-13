package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "DeliveryNotes row Issue request information", value = "DeliveryRowIssueData")
@Getter
public class DeliveryNoteRowIssueDataDTO {

    @ApiModelProperty(position = 1)
    private Float docPackQuantity;

    @ApiModelProperty(position = 2)
    private Float docQuantity;

    @ApiModelProperty(position = 3)
    private Float deliveryQuantity;

    @ApiModelProperty(position = 4)
    private Float amount;

    @ApiModelProperty(position = 5)
    private Integer swChecked;

    @ApiModelProperty(position = 6)
    private Integer issueType;

    @ApiModelProperty(position = 7)
    private String comments;

    public String getComments() {
        return this.comments == null ? "" : this.comments;

    }
}

