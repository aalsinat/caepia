package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(UserApplicationParameterPK.class)
@Table(name = "vApiUserParams")
public class UserApplicationParameter {
    @Id
    @Column(name = "PK_User")
    @JsonIgnore
    private Integer userId;

    @Column(name = "PK_Param")
    private String paramId;
}
