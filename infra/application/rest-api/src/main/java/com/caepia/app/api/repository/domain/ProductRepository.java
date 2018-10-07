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
     * Query for fetching information about an authorized {@link Product} to a particular {@code Center}, a particular  {@code Vendor}.
     *
     * @param centerId        identifier for the center
     * @param vendorId        identifier for the vendor
     * @param productId       identifier for the product
     * @param logisticChainId identifier for the product
     * @return information about requested product
     */
    Product findByCenterIdAndVendorIdAndIdAndLogisticChainId(Integer centerId, Integer vendorId,
                                                             Integer productId, Integer logisticChainId);


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


    /**
     * Query for fetching all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center},
     * filtered by status and logistic chain type.
     *
     * @param centerId          identifier for the center
     * @param vendorId          identifier for the vendor
     * @param status            status of the products to be fetched. Default value is 1
     * @param logisticChainType logistic chain type of the products to be fetched. Default value is 1
     * @return list of all provided {@link Product}s filtered by status and logistic chain type
     */
    public Iterable<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainType(Integer centerId,
                                                                                      Integer vendorId,
                                                                                      Integer status,
                                                                                      Integer logisticChainType);

    /**
     * Query for fetching, page by page, all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId          identifier for the center
     * @param vendorId          identifier for the vendor
     * @param status            status of the products to be fetched. Default value is 1
     * @param logisticChainType logistic chain type of the products to be fetched. Default value is 1
     * @param page              requested page
     * @return page of provided {@link Product}s filtered by status and logistic chain type
     */
    public Page<Product> getAllByCenterIdAndVendorIdAndStatusAndLogisticChainType(Integer centerId,
                                                                                  Integer vendorId,
                                                                                  Integer status,
                                                                                  Integer logisticChainType,
                                                                                  Pageable page);

}
