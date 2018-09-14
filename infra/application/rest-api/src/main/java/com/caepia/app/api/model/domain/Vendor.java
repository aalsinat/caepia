package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(VendorPK.class)
@Table(name = "vApiCenterVendors")
public class Vendor {
    @Id
    @Column(name = "PK_CostCenter")
    private Integer centerId;
    @Id
    @Column(name = "PK_Vendor")
    private Integer vendorId;
}
