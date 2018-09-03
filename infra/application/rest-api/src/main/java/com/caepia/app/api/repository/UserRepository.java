package com.caepia.app.api.repository;

import com.caepia.app.api.model.DatabaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


public interface UserRepository extends JpaRepository<DatabaseUser, Integer> {

	boolean existsByUsername(String username);

	DatabaseUser findByUsername(String username);

	@Transactional
	void deleteByUsername(String username);

}