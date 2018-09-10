package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "UsersApp")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserApplicationDetails {
    @Id
    @Column(name = "PK_User")
    private Integer userId;

    @Column(name = "UK_UserLogin")
    private String loginId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Status")
    private Integer status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PK_User ")
    Set<UserApplicationCenter> centers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PK_User")
    Set<UserApplicationPermission> permissions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PK_User")
    Set<UserApplicationParameter> parameters;
}
