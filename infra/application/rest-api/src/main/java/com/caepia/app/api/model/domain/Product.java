package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ProductPK.class)
@Table(name = "vApiVendorCostCentersProducts")
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

    @Column(name = "swBookmark")
    private Integer isBookmarked;

}
