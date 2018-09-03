package com.caepia.app.api.model;

import usermanager.api.entity.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CaepiaAppUsers")
public class DatabaseUser implements User {

//	@ElementCollection(fetch = FetchType.EAGER)
//	List<Role> roles;
	@Id
	@Column(name = "PK_User")
	private String id;

	@Size(min = 3, max = 128, message = "Minimum username length: 3 characters")
	@Column(name = "Name")
	private String username;

	@Size(max = 128)
	@Column(name = "Password")
	private String password;
	@Column(name = "Status")
	private Integer status;
	@Column(name = "FK_Client")
	private Integer clientId;

//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		DatabaseUser that = (DatabaseUser) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(username, that.username) &&
				Objects.equals(password, that.password) &&
				Objects.equals(status, that.status) &&
				Objects.equals(clientId, that.clientId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, status, clientId);

	}

	@Override
	public String toString() {
		return "DatabaseUser{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", status=" + status +
				", clientId=" + clientId +
				'}';
	}
}