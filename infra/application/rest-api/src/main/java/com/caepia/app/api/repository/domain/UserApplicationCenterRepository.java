package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.UserApplicationCenter;
import com.caepia.app.api.model.domain.UserApplicationCenterPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationCenterRepository extends JpaRepository<UserApplicationCenter, UserApplicationCenterPK> {
}
