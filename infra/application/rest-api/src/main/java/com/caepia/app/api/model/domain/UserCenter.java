package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(UserCenterPK.class)
@Table(name = "vApiUserCenters")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "User Centers", description = "Centers allowed to be managed by the user.")
public class UserCenter implements Serializable {
    @Id
    @Column(name = "PK_User")
    @JsonIgnore
    private Integer userId;

    @Id
    @Column(name = "PK_CostCenter")
    private Integer costCenter;
}
