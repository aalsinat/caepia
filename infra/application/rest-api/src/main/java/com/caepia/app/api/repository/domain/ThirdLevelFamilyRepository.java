package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ThirdLevelFamily;
import com.caepia.app.api.model.domain.ThirdLevelFamilyPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdLevelFamilyRepository extends JpaRepository<ThirdLevelFamily, ThirdLevelFamilyPK> {
    /**
     * Query for fetching all authorized {@link ThirdLevelFamilyRepository}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @return a list of authorized {@link ThirdLevelFamilyRepository}s.
     */
    Iterable<ThirdLevelFamily> findAllByCenterId(Integer centerId);

    /**
     * Query for fetching, page by page, all authorizes {@link ThirdLevelFamilyRepository}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link ThirdLevelFamilyRepository}s
     */
    Page<ThirdLevelFamily> findAllByCenterId(Integer centerId, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link ThirdLevelFamilyRepository}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param vendorId       identifier for the found vendor
     * @param page     requested page
     * @return a page of authorized {@link ThirdLevelFamilyRepository}s
     */
    Page<ThirdLevelFamily> findAllByCenterIdAndVendorId(Integer centerId, Integer vendorId, Pageable page);

    /**
     * Query for fetching information about an authorized {@link ThirdLevelFamilyRepository} to a particular {@code Center}.
     *
     * @param centerId identifier for a center
     * @param vendorId       identifier for the found vendor
     * @return information about requested vendor
     */
    Iterable<ThirdLevelFamily> findAllByCenterIdAndVendorId(Integer centerId, Integer vendorId);


}
