package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@IdClass(ProductsReceiptPK.class)
@Table(name = "vAPIProdOrdersProductsByReceipt")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "updateProductionOrderRow",
                                   procedureName = "spApiPutProdOrderProduct")})
public class ProductsReceipt extends ModelEntity {

    @Id
    @Column(name = "PK_ProductionOrder")
    private Integer productionOrderId;
    @Id
    @Column(name = "PK_Row")
    private Integer rowId;
    //@Id
    // La vista te valors nulls en aquest camp de manera que no pot ser mai PK
    // TODO: Validar amb Eduard que realment es aixi
    @Column(name = "PK_SalesProduct")
    private Integer salesProductId;

    @Column(name = "FK_Product")
    private Integer productId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "SalesProductName")
    private String salesProductName;

    @Column(name = "ReceiptCount")
    private Integer receiptCount;

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
    private String type;

    @Column(name = "FK_CategoryL3")
    private Integer CategoryL3Id;

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


}

