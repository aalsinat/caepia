package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.UserCenter;
import com.caepia.app.api.model.domain.UserCenterPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCenterRepository extends JpaRepository<UserCenter, UserCenterPK> {
}
