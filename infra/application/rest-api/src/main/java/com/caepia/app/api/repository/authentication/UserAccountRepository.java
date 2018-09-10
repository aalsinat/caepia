package com.caepia.app.api.repository.authentication;

import com.caepia.app.api.model.authentication.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String>, UserAuthenticationRepository {


	boolean existsByUsername(String username);

	UserAccount findByUsername(String username);

	@Transactional
	void deleteByUsername(String username);

}