package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.UserApplicationPermission;
import com.caepia.app.api.model.domain.UserApplicationPermissionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationPermissionsRepository extends JpaRepository<UserApplicationPermission, UserApplicationPermissionPK> {
}
