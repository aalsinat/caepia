package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@IdClass(ProductPK.class)
@Table(name = "vApiVendorCostCentersProducts")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "updateBookmark",
                                   procedureName = "spApiPutCatalogSetBookmark")})
public class Product extends ModelEntity {
    @Id
    @Column(name = "PK_CostCenter")
    private Integer centerId;
    @Id
    @Column(name = "PK_Vendor")
    private Integer vendorId;
    @Id
    @Column(name = "PK_LogisticChain")
    private Integer logisticChainId;
    @Id
    @Column(name = "PK_Product")
    private Integer id;

    @Column(name = "LogisticChainType")
    private Integer logisticChainType;

    @Column(name = "FK_Pack")
    private Integer packId;

    @Column(name = "PackItems")
    private Float packItems;

    @Column(name = "VendorRef")
    private String vendorRef;

    @Column(name = "swOrderEnabled")
    private Integer swOrderEnabled;

    @Column(name = "CurrentCost")
    private Float currentCost;

    @Column(name = "CurrentCostFormat")
    private String currentCostFormat;

    @Column(name = "CurrentCostTax")
    private Float currentCostTax;

    @Column(name = "CurrentCostTrend")
    private Integer currentCostTrend;

    @Column(name = "swBookmark")
    private Integer isBookmarked;

    @Column(name = "MinimumOrder")
    private Float minimumOrder;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "PackName")
    private String packName;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "FK_CategoryL3")
    private Integer categoryL3Id;

    @Column(name = "CategoryL3Name")
    private String categoryL3Name;

    @Column(name = "FK_Unit")
    private Integer unitId;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "UnitShortName")
    private String unitShortName;

    @Column(name = "CostBaseUnits")
    private Float costBaseUnits;

    @Column(name = "CostBaseUnitsFormat")
    private String costBaseUnitsFormat;

    @Column(name = "BaseUnitShortName")
    private String baseUnitShortName;

    @Column(name = "EAN")
    private String EAN;

    @Column(name = "TaxCode", nullable = true)
    private Integer taxCode;

    @Column(name = "VendorDesc")
    private String vendorDesc;

    @Column(name = "VendorFeatures", nullable = true)
    private String vendorFeatures;

    @Column(name = "VendorCategory", nullable = true)
    private String vendorCategory;


}

