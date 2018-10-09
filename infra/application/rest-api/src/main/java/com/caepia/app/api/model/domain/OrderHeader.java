package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Data
@Entity
@IdClass(OrderHeaderPK.class)
@Table(name = "vApiOrdersHeader")
public class OrderHeader {
    @Id
    @Column(name = "PK_Order")
    private Integer orderId;

    @Column(name = "OrderNum")
    private String orderNumber;

    @Column(name = "FK_CostCenter")
    private Integer centerId;

    @Column(name = "FK_vendor")
    private Integer vendorId;

    @Column(name = "OrderDate")
    private GregorianCalendar orderDate;

    @Column(name = "TotalAmount")
    private Float TotalAmount;

    @Column(name = "TotalAmountTax")
    private Float TotalAmountTax;

    @Column(name = "TotalTax")
    private Float TotalTax;

    @Column(name = "DeliveryDate")
    private GregorianCalendar deliveryDate;

    @Column(name = "DeliveryPlanDate")
    private GregorianCalendar deliveryPlanDate;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "FK_ProductionOrder")
    private Integer productionOrderId;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Owner")
    private Integer owner;

    @Column(name = "UserSent")
    private Integer userSent;

    @Column(name = "CostCenterName")
    private String centerName;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "SendChannels")
    private Integer sendChannels;

    @Column(name = "CalendarInfo")
    private String calendarInfo;

    @Column(name = "CatalogType")
    private Integer catalogType;

    @Column(name = "ContactCellPhone")
    private String contactCellPhone;







}
