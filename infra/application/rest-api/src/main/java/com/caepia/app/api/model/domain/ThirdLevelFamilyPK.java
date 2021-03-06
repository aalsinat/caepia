package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class ThirdLevelFamilyPK implements Serializable {
    @Id
    @Column(name = "PK_CostCenter")
    private Integer centerId;

    @Id
    @Column(name = "PK_Vendor")
    private Integer vendorId;

    @Id
    @Column(name = "FK_CategoryL3")
    private Integer id;
}
