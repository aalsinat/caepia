package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.UserApplicationParameter;
import com.caepia.app.api.model.domain.UserApplicationParameterPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationParameterRepository extends JpaRepository<UserApplicationParameter, UserApplicationParameterPK> {
}
