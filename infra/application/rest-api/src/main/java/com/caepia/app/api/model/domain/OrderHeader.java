package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@Entity
@IdClass(OrderHeaderPK.class)
@Table(name = "vApiOrdersHeader")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "sendOrder",
                procedureName = "spApiPutSendOrder"),
        @NamedStoredProcedureQuery(name = "createOrderHeader",
                procedureName = "spApiPostOrderHeader"),
        @NamedStoredProcedureQuery(name = "updateOrderHeader",
                procedureName = "spApiPutOrderHeader"),
        @NamedStoredProcedureQuery(name = "copyOrder",
                procedureName = "spApiPostCopyOrder"),
        @NamedStoredProcedureQuery(name = "cancelOrder",
                procedureName = "spApiPutCancelOrder"),
        @NamedStoredProcedureQuery(name = "receiveOrder",
                procedureName = "spApiPutReceiveOrder")})
public class OrderHeader extends ModelEntity {
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
    private String orderDate;

    @Column(name = "TotalAmount")
    private Float TotalAmount;

    @Column(name = "TotalAmountTax")
    private Float TotalAmountTax;

    @Column(name = "TotalTax")
    private Float TotalTax;

    @Column(name = "DeliveryDate")
    private String deliveryDate;

    @Column(name = "DeliveryPlanDate")
    private String deliveryPlanDate;

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
