package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ThirdLevelFamilyPK.class)
@Table(name = "vAPICenterVendorsCategoriesL3")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThirdLevelFamily {
    @Id
    @Column(name = "PK_CostCenter")
    private Integer centerId;

    @Id
    @Column(name = "PK_Vendor")
    private Integer vendorId;

    @Id
    @Column(name = "FK_CategoryL3")
    private Integer id;

    @Column(name = "CategoryName")
    private String categoryName;
}

