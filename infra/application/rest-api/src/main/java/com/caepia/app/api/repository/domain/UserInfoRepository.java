package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    /**
     * Retrieves application information using a login identifier.
     *
     * @param username Identifier of a login user
     * @return {@link UserInfo} information for provided login id
     */
    UserInfo findByUsername(String username);
}
