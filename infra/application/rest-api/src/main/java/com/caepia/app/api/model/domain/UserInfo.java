package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "UsersApp")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    @Id
    @Column(name = "PK_User")
    private Integer userId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PK_User ")
    Set<UserCenter> centers;

    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PK_User")
    Set<UserPermission> permissions;

    @Column(name = "Email")
    private String email;

    @Column(name = "Status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PK_User")
    Set<UserParameter> parameters;
    @Column(name = "UK_UserLogin")
    private String username;
    @Column(name = "Surname")
    private String surname;
}
