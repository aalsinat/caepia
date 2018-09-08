package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.UserApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationDetailsRepository extends JpaRepository<UserApplicationDetails, Integer> {
    /**
     * Retrieves application information using a login identifier.
     *
     * @param loginId Identifier of a login user
     * @return {@link UserApplicationDetails} information for provided login id
     */
    UserApplicationDetails findByLoginId(String loginId);
}
