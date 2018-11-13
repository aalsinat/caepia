package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@Entity
@IdClass(DeliveryNoteRowPK.class)
@Table(name = "vApiDeliveryNotesRows")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "createDeliveryNoteRow",
                procedureName = "spApiPostDeliveryNoteRow"),
        @NamedStoredProcedureQuery(name = "updateDeliveryNoteRow",
                procedureName = "spApiPutDeliveryNoteRow"),
        @NamedStoredProcedureQuery(name = "issueDeliveryNotesRow",
                procedureName = "spApiPutIssueDeliveryNoteRow")})

public class DeliveryNoteRow extends ModelEntity{

    @Id
    @Column(name = "PK_DeliveryNote")
    private Integer deliveryNoteId;
    @Id
    @Column(name = "PK_Row")
    private Integer rowId;

    @Column(name = "FK_CostCenter")
    private Integer FK_CostCenter;

    @Column(name = "FK_Vendor")
    private Integer FK_Vendor;

    @Column(name = "FK_Product")
    private Integer productId;

    @Column(name = "FK_LogisticChain")
    private Integer logisticChainId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "PackName")
    private String packName;

    @Column(name = "DocPackQuantity")
    private Float docPackQuantity;

    @Column(name = "DocQuantity")
    private Float docQuantity;

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


    @Column(name = "CategoryL3Name")
    private String categoryL3Name;


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

    @Column(name = "OrderQuantity")
    private Float orderQuantity;

    @Column(name = "DeliveryQuantity")
    private Float deliveryQuantity;

    @Column(name = "CatalogAmount")
    private Float catalogAmount;

    @Column(name = "CatalogAmountTax")
    private Float catalogAmountTax;

    @Column(name = "CatalogTaxCode")
    private Integer catalogTaxCode;

    @Column(name = "CatalogTax")
    private Float catalogTax;

    @Column(name = "swChecked")
    private Integer swChecked;

    @Column(name = "IssueType")
    private Integer issueType;

    @Column(name = "Comments")
    private String comments;




}