package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.UserParameter;
import com.caepia.app.api.model.domain.UserParameterPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserParameterRepository extends JpaRepository<UserParameter, UserParameterPK> {
}
