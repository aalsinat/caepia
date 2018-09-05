package com.caepia.app.api.repository;

import com.caepia.app.api.dto.LoginResult;
import com.caepia.app.api.model.DatabaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<DatabaseUser, String>, UserAuthenticationRepository {


	boolean existsByUsername(String username);

	DatabaseUser findByUsername(String username);

	@Transactional
	void deleteByUsername(String username);

}