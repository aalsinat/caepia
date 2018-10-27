package com.caepia.app.api.model.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class SalesProductPK implements Serializable {
    @Id
    @Column(name = "PK_CostCenter")
    private Integer centerId;
    @Id
    @Column(name = "PK_ProductionOrder")
    private Integer productionOrderId;
    @Id
    @Column(name = "PK_SalesProduct")
    private Integer salesProductId;

}

