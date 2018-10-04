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

    @Column(name = "Comments")
    private String comments;

    @Column(name = "DeliveryDate")
    private GregorianCalendar deliveryDate;

    @Column(name = "DeliveryPlanDate")
    private GregorianCalendar deliveryPlanDate;

    @Column(name = "CostCenterName")
    private String centerName;

    @Column(name = "UserSent")
    private String userSent;

    @Column(name = "VendorName")
    private String vendorName;


}
