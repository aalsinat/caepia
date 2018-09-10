package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class UserPermissionPK implements Serializable {
    @Id
    @Column(name = "PK_User")
    private Integer userId;

    @Id
    @Column(name = "PK_Profile")
    private String profile;
}
