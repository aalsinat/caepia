package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class UserParameterPK implements Serializable {
    @Id
    @Column(name = "PK_User")
    @JsonIgnore
    private Integer userId;

    @Column(name = "PK_Param")
    private String paramId;
}
