package com.caepia.app.api.model.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class ProductsReceiptPK implements Serializable {
    @Id
    @Column(name = "PK_ProductionOrder")
    private Integer productionOrderId;
    @Id
    @Column(name = "PK_Row")
    private Integer rowId;
    @Id
    @Column(name = "PK_SalesProduct")
    private Integer salesProductId;


}