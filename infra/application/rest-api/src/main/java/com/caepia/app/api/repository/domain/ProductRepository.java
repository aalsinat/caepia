package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.Product;
import com.caepia.app.api.model.domain.ProductPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductPK>, ProductManagementRepository {

    /**
     * Query for fetching all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId identifier for the center
     * @param vendorId identifier for the vendor
     * @return list of all provided {@link Product}s
     */
    public Iterable<Product> getAllByCenterIdAndVendorId(Integer centerId, Integer vendorId);

    /**
     * Query for fetching, page by page, all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId identifier for the center
     * @param vendorId identifier for the vendor
     * @param page     requested page
     * @return page of provided {@link Product}s
     */
    public Page<Product> getAllByCenterIdAndVendorId(Integer centerId, Integer vendorId, Pageable page);
}
