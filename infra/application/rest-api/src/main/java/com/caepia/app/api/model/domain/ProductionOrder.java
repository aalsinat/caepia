package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@Entity
@Table(name = "vAPIProdOrdersHeader")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "createProductionOrder",
                                   procedureName = "spApiPostProductOrderHeader"),
        @NamedStoredProcedureQuery(name = "changeStatus",
                                   procedureName = "spApiPutStatusProductOrder")})
public class ProductionOrder extends ModelEntity {
    // Si la PK es un unic camp, no cal definir una entitat PK
    @Id
    @Column(name = "PK_ProductionOrder")
    private Integer productionOrderId;

    @Column(name = "ProductionOrderNum")
    private String productionOrderNum;

    @Column(name = "FK_CostCenter")
    private Integer centerId;

    @Column(name = "ProdOrderDate")
    private String prodOrderDate;

    @Column(name = "StrProdOrderDateFromNow")
    private String prodOrderDateFromNow;


    @Column(name = "Status")
    private Integer status;

    @Column(name = "Owner")
    private Integer owner;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "CostCenterName")
    private String centerName;
}
