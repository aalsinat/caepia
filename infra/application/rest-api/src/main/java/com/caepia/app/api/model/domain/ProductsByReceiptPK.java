package com.caepia.app.api.model.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class ProductsByReceiptPK implements Serializable {
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
}
