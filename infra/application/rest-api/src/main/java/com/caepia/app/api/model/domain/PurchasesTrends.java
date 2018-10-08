package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(PurchasesTrendsPK.class)
@Table(name = "vApiPurchasesTrends")
public class PurchasesTrends {
    @Id
    @Column(name = "PK_Product")
    private Integer productId;

    @Id
    @Column(name = "PK_CostCenter")
    private Integer centerId;

    @Id
    @Column(name = "PK_Vendor")
    private Integer vendorId;

    @Column(name = "GraphType", nullable = true)
    private Integer graphType;

    @Column(name = "BeginMonth", nullable = true)
    private Integer beginMonth;

    @Column(name = "BeginYear", nullable = true)
    private Integer beginYear;

    @Column(name = "ValueMonth1", nullable = true)
    private Float valueMonth1;

    @Column(name = "ValueMonth2", nullable = true)
    private Float valueMonth2;

    @Column(name = "ValueMonth3", nullable = true)
    private Float valueMonth3;

    @Column(name = "ValueMonth4", nullable = true)
    private Float valueMonth4;

    @Column(name = "ValueMonth5", nullable = true)
    private Float valueMonth5;

    @Column(name = "ValueMonth6", nullable = true)
    private Float valueMonth6;

    @Column(name = "ValueMonth7", nullable = true)
    private Float valueMonth7;

    @Column(name = "ValueMonth8", nullable = true)
    private Float valueMonth8;

    @Column(name = "ValueMonth9", nullable = true)
    private Float valueMonth9;

    @Column(name = "ValueMonth10", nullable = true)
    private Float valueMonth10;

    @Column(name = "ValueMonth11", nullable = true)
    private Float valueMonth11;

    @Column(name = "ValueMonth12", nullable = true)
    private Float valueMonth12;

    @Column(name = "ValueKpi1", nullable = true)
    private Float valueKpi1;

    @Column(name = "ValueKpi2", nullable = true)
    private Float valueKpi2;

    @Column(name = "ValueKpi3", nullable = true)
    private Float valueKpi3;


}
