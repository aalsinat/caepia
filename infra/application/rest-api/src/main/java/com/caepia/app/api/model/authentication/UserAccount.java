package com.caepia.app.api.model.authentication;

import usermanager.api.entity.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(status, that.status) &&
                Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, password, status, clientId);

    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", clientId=" + clientId +
                '}';
    }
}