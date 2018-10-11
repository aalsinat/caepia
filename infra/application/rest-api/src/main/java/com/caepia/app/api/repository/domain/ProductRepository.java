package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.Product;
import com.caepia.app.api.model.domain.ProductPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings(value = "unused")
public interface ProductRepository extends JpaRepository<Product, ProductPK>, ProductManagementRepository {
    /**
     * Query for fetching information about an authorized {@link Product} to a particular {@code Center}, a particular  {@code Vendor}.
     *
     * @param centerId        identifier for the center
     * @param vendorId        identifier for the vendor
     * @param productId       identifier for the product
     * @param logisticChainId identifier for the product
     * @return information about requested product
     */
    Iterable<Product> findByCenterIdAndVendorIdAndIdAndLogisticChainId(Integer centerId, Integer vendorId, Integer productId, Integer logisticChainId);


    /**
     * Query for fetching information about an authorized {@link Product} to a particular {@code Center}, a particular  {@code Vendor}.
     *
     * @param centerId  identifier for the center
     * @param vendorId  identifier for the vendor
     * @param productId identifier for the product
     * @return information about requested product
     */
    Iterable<Product> findByCenterIdAndVendorIdAndId(Integer centerId, Integer vendorId, Integer productId);


    /* Without pagination */

    /* 
        Without filters 
     */

    Iterable<Product> getAllByCenterIdAndVendorId(Integer centerId, Integer vendorId);

    /* 
        Starting with status filter 
     */

    Iterable<Product> getAllByCenterIdAndVendorIdAndStatus(Integer centerId, Integer vendorId, Integer status);

    Iterable<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainType(Integer centerId, Integer vendorId, Integer status, Integer logisticChainType);

    Iterable<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainTypeAndCategoryL3Id(Integer centerId, Integer vendorId, Integer status, Integer logisticChainType, Integer categoryL3Id);

    Iterable<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainTypeAndIsBookmarked(Integer centerId, Integer vendorId, Integer status, Integer logisticChainType, Integer isBookmarked);

    Iterable<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainTypeAndCategoryL3IdAndIsBookmarked(Integer centerId, Integer vendorId, Integer status, Integer logisticChainType, Integer categoryL3Id, Integer isBookmarked);

    Iterable<Product> getAllByCenterIdAndVendorIdAndStatusAndCategoryL3Id(Integer centerId, Integer vendorId, Integer status, Integer categoryL3Id);

    Iterable<Product> getAllByCenterIdAndVendorIdAndStatusAndCategoryL3IdAndIsBookmarked(Integer centerId, Integer vendorId, Integer status, Integer categoryL3Id, Integer isBookmarked);

    Iterable<Product> getAllByCenterIdAndVendorIdAndStatusAndIsBookmarked(Integer centerId, Integer vendorId, Integer status, Integer isBookmarked);

    /* 
        Starting with logistic chain type filter 
     */

    Iterable<Product> getAllByCenterIdAndVendorIdAndLogisticChainType(Integer centerId, Integer vendorId, Integer logisticChainType);

    Iterable<Product> getAllByCenterIdAndVendorIdAndLogisticChainTypeAndCategoryL3Id(Integer centerId, Integer vendorId, Integer logisticChainType, Integer categoryL3Id);

    Iterable<Product> getAllByCenterIdAndVendorIdAndLogisticChainTypeAndIsBookmarked(Integer centerId, Integer vendorId, Integer logisticChainType, Integer isBookmarked);

    Iterable<Product> getAllByCenterIdAndVendorIdAndLogisticChainTypeAndCategoryL3IdAndIsBookmarked(Integer centerId, Integer vendorId, Integer logisticChainType, Integer categoryL3Id, Integer isBookmarked);

    /* 
        Starting with category L3 filter 
     */

    Iterable<Product> getAllByCenterIdAndVendorIdAndCategoryL3Id(Integer centerId, Integer vendorId, Integer categoryL3Id);

    Iterable<Product> getAllByCenterIdAndVendorIdAndCategoryL3IdAndIsBookmarked(Integer centerId, Integer vendorId, Integer categoryL3Id, Integer isBookmarked);


    /*
        With pagination 
     */
    
    /* 
        Without filters 
     */

    Page<Product> getAllByCenterIdAndVendorId(Integer centerId, Integer vendorId, Pageable page);

    /* 
        Starting with status filter 
     */

    Page<Product> getAllByCenterIdAndVendorIdAndStatus(Integer centerId, Integer vendorId, Integer status, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainType(Integer centerId, Integer vendorId, Integer status, Integer logisticChainType, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainTypeAndCategoryL3Id(Integer centerId, Integer vendorId, Integer status, Integer logisticChainType, Integer categoryL3Id, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainTypeAndIsBookmarked(Integer centerId, Integer vendorId, Integer status, Integer logisticChainType, Integer isBookmarked, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainTypeAndCategoryL3IdAndIsBookmarked(Integer centerId, Integer vendorId, Integer status, Integer logisticChainType, Integer categoryL3Id, Integer isBookmarked, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndStatusAndCategoryL3Id(Integer centerId, Integer vendorId, Integer status, Integer categoryL3Id, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndStatusAndCategoryL3IdAndIsBookmarked(Integer centerId, Integer vendorId, Integer status, Integer categoryL3Id, Integer isBookmarked, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndStatusAndIsBookmarked(Integer centerId, Integer vendorId, Integer status, Integer isBookmarked, Pageable page);

    /* 
        Starting with logistic chain type filter 
     */

    Page<Product> getAllByCenterIdAndVendorIdAndLogisticChainType(Integer centerId, Integer vendorId, Integer logisticChainType, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndLogisticChainTypeAndCategoryL3Id(Integer centerId, Integer vendorId, Integer logisticChainType, Integer categoryL3Id, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndLogisticChainTypeAndIsBookmarked(Integer centerId, Integer vendorId, Integer logisticChainType, Integer isBookmarked, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndLogisticChainTypeAndCategoryL3IdAndIsBookmarked(Integer centerId, Integer vendorId, Integer logisticChainType, Integer categoryL3Id, Integer isBookmarked, Pageable page);

    /* 
        Starting with category L3 filter 
     */

    Page<Product> getAllByCenterIdAndVendorIdAndCategoryL3Id(Integer centerId, Integer vendorId, Integer categoryL3Id, Pageable page);

    Page<Product> getAllByCenterIdAndVendorIdAndCategoryL3IdAndIsBookmarked(Integer centerId, Integer vendorId, Integer categoryL3Id, Integer isBookmarked, Pageable page);
}
