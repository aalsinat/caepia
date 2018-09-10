package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.UserPermission;
import com.caepia.app.api.model.domain.UserPermissionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, UserPermissionPK> {
}
