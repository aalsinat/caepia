package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    /**
     * Query for fetching all authorized {@link Vendor}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @return a list of authorized {@link Vendor}s.
     */
    Iterable<ModelEntity> findAllByCenterId(Integer centerId);


    /**
     * Query for fetching all authorized {@link Vendor}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @return a list of authorized {@link Vendor}s.
     */
    Iterable<ModelEntity> findAllByCenterIdOrderByVendorName(Integer centerId);



    /**
     * Query for fetching all authorized {@link Vendor}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the center
     * @return a list of authorized {@link Vendor}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatus(Integer centerId, Integer status);


    /**
     * Query for fetching, page by page, all authorizes {@link Vendor}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link Vendor}s
     */
    Page<ModelEntity> findAllByCenterId(Integer centerId, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link Vendor}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link Vendor}s
     */
    Page<ModelEntity> findAllByCenterIdOrderByVendorName(Integer centerId, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link Vendor}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status    status filter
     * @param page     requested page
     * @return a page of authorized {@link Vendor}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatus(Integer centerId, Integer status, Pageable page);

    /**
     * Query for fetching information about an authorized {@link Vendor} to a particular {@code Center}.
     *
     * @param centerId identifier for a center
     * @param id       identifier for the found vendor
     * @return information about requested vendor
     */
    Vendor findByCenterIdAndId(Integer centerId, Integer id);


}
