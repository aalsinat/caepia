package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ProductUnitsPK.class)
@Table(name = "vApiProductUnits")
public class ProductUnits {
    @Id
    @Column(name = "PK_Unit")
    private Integer unitId;

    @Column(name = "Name")
    private String name;

    @Column(name = "ShortName")
    private String shortName;

    @Column(name = "Status")
    private Integer status;

}
