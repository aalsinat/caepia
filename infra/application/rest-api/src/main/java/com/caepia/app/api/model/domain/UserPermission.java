package com.caepia.app.api.model.domain;

import com.caepia.app.api.model.authentication.ApplicationPermision;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(UserPermissionPK.class)
@Table(name = "vApiUserPermits")
public class UserPermission implements Serializable, ApplicationPermision {
    @Id
    @Column(name = "PK_User")
    @JsonIgnore
    private Integer userId;

    @Id
    @Column(name = "PK_Profile")
    private String profile;

    @Column(name = "Actions")
    private String actions;
}
