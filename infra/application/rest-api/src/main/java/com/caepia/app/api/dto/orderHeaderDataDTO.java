package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.text.SimpleDateFormat;

@ApiModel(description = "Order header request information", value = "OrderHeaderData")
public class orderHeaderDataDTO {
    @ApiModelProperty(position = 1, required = true)
    private Integer costCenter;

    @ApiModelProperty(position = 2, required = true)
    private String orderDate;

    @ApiModelProperty(position = 3, required = true)
    private Integer vendor;

    @ApiModelProperty(position = 4, required = true)
    private String deliveryPlanDate;

    @ApiModelProperty(position = 5)
    private String comments;

    public Integer getCostCenter() {
        return this.costCenter;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public Integer getVendor() {
        return this.vendor;
    }

    public String getDeliveryPlanDate() {
        return this.deliveryPlanDate;
    }

    public String getComments() {
        return this.comments == null ? "" : this.comments;

    }


}
