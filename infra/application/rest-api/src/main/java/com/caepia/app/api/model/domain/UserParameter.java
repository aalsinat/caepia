package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(UserParameterPK.class)
@Table(name = "vApiUserParams")
public class UserParameter {
    @Id
    @Column(name = "PK_User")
    @JsonIgnore
    private Integer userId;

    @Column(name = "PK_Param")
    private String paramId;
}
