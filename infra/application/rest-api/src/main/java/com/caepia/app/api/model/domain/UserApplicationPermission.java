package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(UserApplicationPermissionPK.class)
@Table(name = "vApiUserPermits")
public class UserApplicationPermission implements Serializable {
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
