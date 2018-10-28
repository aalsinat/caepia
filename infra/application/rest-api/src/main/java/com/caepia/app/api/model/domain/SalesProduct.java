package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@IdClass(SalesProductPK.class)
@Table(name = "vAPIProdOrdersSalesProducts")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "updateSalesProductRow",
                procedureName = "spApiPutProdOrderSalesProduct")})

public class SalesProduct extends ModelEntity {
    @Id
    @Column(name = "PK_ProductionOrder")
    private Integer productionOrderId;
    @Id
    @Column(name = "PK_SalesProduct")
    private Integer salesProductId;

    @Column(name = "Quantity")
    private String quantity;

    @Column(name = "Name")
    private String name;

    @Column(name = "UnitsName")
    private String unitsName;




}

