package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(OrderRowPK.class)
@Table(name = "vApiOrdersRows")
public class OrderRow {
    @Id
    @Column(name = "PK_Order")
    private Integer orderId;
    @Id
    @Column(name = "PK_Row")
    private Integer rowId;

    @Column(name = "FK_Product")
    private Integer productId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "PackName")
    private String packName;

    @Column(name = "PackQuantity")
    private Float packQuantity;

    @Column(name = "BaseQuantity")
    private Float baseQuantity;

    @Column(name = "PackCost")
    private Integer packCost;

    @Column(name = "PackCostTax")
    private Integer packCostTax;

    @Column(name = "BaseCost")
    private Integer baseCost;

    @Column(name = "BaseCostTax")
    private Integer baseCostTax;

    @Column(name = "Amount")
    private Float amount;

    @Column(name = "AmountTax")
    private Float amountTax;

    @Column(name = "TaxCode")
    private Integer taxCode;

    @Column(name = "getType")
    private String getType;

    @Column(name = "FK_CategoryL3")
    private Integer categoryL3Id;

    @Column(name = "swBookmark")
    private Integer swBookmark;

    @Column(name = "UnitShortName")
    private String unitShortName;

    @Column(name = "PackItems")
    private Float packItems;

    @Column(name = "CurrentCostTrend")
    private Integer currentCostTrend;

    @Column(name = "MinimumOrder")
    private Float minimumOrder;

    @Column(name = "VendorRef")
    private String vendorRef;

    @Column(name = "VendorDesc")
    private String vendorDesc;




}