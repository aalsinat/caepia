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

    @Column(name = "FK_CategoryL3")
    private Integer categoryL;

    @Column(name = "VendorRef")
    private String vendorRef;

    @Column(name = "VendorDesc")
    private String vendorDesc;

    @Column(name = "Amount")
    private Float amount;

    @Column(name = "AmountTax")
    private Float amountTax;


}