package com.caepia.app.api.repository;

import com.caepia.app.api.model.DatabaseUser;
import com.caepia.app.api.model.LoginResponseFromStored;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<DatabaseUser, String> {


	boolean existsByUsername(String username);

	DatabaseUser findByUsername(String username);

	@Transactional
	void deleteByUsername(String username);

	/*
	Stored procedures for all PUT and POST requests
	 */
	@Procedure(procedureName = "spApiPostLogin")
	void login(@Param("pUser") String user, @Param("pPassword") String password, @Param("pVersion") Integer version);

}