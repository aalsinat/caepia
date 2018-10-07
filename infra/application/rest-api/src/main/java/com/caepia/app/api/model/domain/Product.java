package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ProductPK.class)
@Table(name = "vApiVendorCostCentersProducts")
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "updateBookmark",
                procedureName = "spApiPutCatalogBookmark")})
public class Product {
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

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "CostBaseUnits")
    private Float costBaseUnits;

    @Column(name = "UnitShortName")
    private String unitShortName;

    @Column(name = "CostBaseUnitsFormat")
    private String costBaseUnitsFormat;

    @Column(name = "swBookmark")
    private Integer isBookmarked;

    @Column(name = "LogisticChainType")
    private Integer logisticChainType;

    @Column(name = "Status")
    private Integer status;

}
