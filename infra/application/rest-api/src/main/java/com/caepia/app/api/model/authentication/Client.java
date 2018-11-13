package com.caepia.app.api.model.authentication;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CaepiaClients")
public class Client {
    @Id
    @Column(name = "PK_Client")
    private Integer clientId;
    @Column(name = "Name")
    private String name;
    @Column(name = "ServerName")
    private String serverName;
    @Column(name = "Port")
    private Integer port;
    @Column(name = "BDName")
    private String database;
    @Column(name = "UserBDName")
    private String username;
    @Column(name = "UserDBPassword")
    private String password;
    @Column(name = "Version")
    private Integer version;
}
