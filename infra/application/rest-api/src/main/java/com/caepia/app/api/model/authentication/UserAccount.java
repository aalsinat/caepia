package com.caepia.app.api.model.authentication;

import lombok.Data;
import usermanager.api.entity.User;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "CaepiaAppUsers")
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "signin",
                procedureName = "spApiPostLogin"//,
//				parameters = {
//						@StoredProcedureParameter(mode = ParameterMode.IN, name = "pUser", type = String.class),
//						@StoredProcedureParameter(mode = ParameterMode.IN, name = "pPassword", type = String.class),
//						@StoredProcedureParameter(mode = ParameterMode.IN, name = "pVersion", type = Integer.class)
//				}
        )
})
public class UserAccount implements User {
    @Id
    @Column(name = "PK_User")
    @Size(min = 3, max = 128, message = "Minimum name length: 3 characters")
    private String username;

    @Column(name = "Name")
    private String name;

    @Size(max = 128)
    @Column(name = "Password")
    private String password;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "FK_Client")
    private Integer clientId;
}