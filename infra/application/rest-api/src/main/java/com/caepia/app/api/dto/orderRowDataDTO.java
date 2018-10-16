package com.caepia.app.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Order row request information", value = "OrderRowData")
public class orderRowDataDTO {
    @ApiModelProperty(position = 1, required = true)
    private Integer orderId;

    @ApiModelProperty(position = 2, required = true)
    private String productName;

    @ApiModelProperty(position = 3, required = true)
    private Integer categoryL3;

    @ApiModelProperty(position = 4, required = true)
    private Integer units;

    @ApiModelProperty(position = 5)
    private Float packQuantity;

    @ApiModelProperty(position = 6)
    private Float cost;

    @ApiModelProperty(position = 7)
    private String comments;


    public Integer getOrderId() {
        return this.orderId;
    }

    public String getProductName() {
        return this.productName;
    }

    public Integer getCategoryL3() {
        return this.categoryL3;
    }

    public Integer getUnits() {
        return this.units;
    }

    public Float getPackQuantity() {
        return this.packQuantity;
    }

    public Float getCost() {
        return this.cost;
    }

    public String getComments() {
        return this.comments == null ? "" : this.comments;

    }




}
