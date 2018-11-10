package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@Entity
@IdClass(DeliveryNoteHeaderPK.class)
@Table(name = "vApiDeliveryNotesHeader")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DeliveryNoteHeader extends ModelEntity {

    @Id
    @Column(name = "PK_DeliveryNote")
    private Integer deliveryNoteId;

    @Column(name = "FK_CostCenter")
    private Integer centerId;

    @Column(name = "DeliveryNoteDate")
    private String deliveryNoteDate;

    @Column(name = "StrDeliveryNoteDateFromNow")
    private String deliveryNoteDateFromNow;

    @Column(name = "FK_vendor")
    private Integer vendorId;

    @Column(name = "VendorNumDoc")
    private String vendorNumDoc;

    @Column(name = "VendorDate")
    private String vendorDate;

    @Column(name = "TotalAmount")
    private Float TotalAmount;

    @Column(name = "TotalAmountTax")
    private Float TotalAmountTax;

    @Column(name = "FK_Order")
    private Integer orderId;

    @Column(name = "FK_Invoice")
    private Integer invoiceId;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Owner")
    private Integer owner;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "CostCenterName")
    private String costCenterName;

    @Column(name = "OwnerName")
    private String ownerName;


}
