package com.caepia.app.api.service.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.exception.UpdateProductBookmarkException;
import com.caepia.app.api.model.domain.Product;
import com.caepia.app.api.repository.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    private final Integer RESULT_OK = 0;
    private final ProductRepository productRepository;


    /**
     * Retrieves all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId        identifier for the center
     * @param vendorId        identifier for the vendor
     * @param productId       identifier for the product
     * @param logisticChainId identifier for the product
     * @return information about requested product
     */
    public Iterable<Product> getProductByVendorIdAndCenterIdAndIdAndLogisticChainId(Integer centerId, Integer vendorId,
                                                                          Integer productId, Integer logisticChainId) {
        return productRepository
                .findByCenterIdAndVendorIdAndIdAndLogisticChainId(centerId, vendorId, productId, logisticChainId);
    }

    /**
     * Retrieves all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId        identifier for the center
     * @param vendorId        identifier for the vendor
     * @param productId       identifier for the product
     * @return information about requested product
     */
    public Iterable<Product> getProductByVendorIdAndCenterIdAndId(Integer centerId, Integer vendorId,
                                                                          Integer productId) {
        return productRepository
                .findByCenterIdAndVendorIdAndId(centerId, vendorId, productId);
    }


    /**
     * Retrieves all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId identifier for the center
     * @param vendorId identifier for the vendor
     * @return list of all products
     */
    public Iterable<Product> getProductsByVendorIdAndCenterId(Integer centerId, Integer vendorId) {
        return productRepository.getAllByCenterIdAndVendorId(centerId, vendorId);
    }


    /**
     * Retrieves all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center},
     * filtered by status and logistic chain type.
     *
     * @param centerId          identifier for the center
     * @param vendorId          identifier for the vendor
     * @param status            status of the products to be fetched. Default value is 1
     * @param logisticChainType logistic chain type of the products to be fetched. Default value is 1
     * @return list of all products filtered by status and logistic chain type
     */
    public Iterable<Product> getProductsByVendorIdAndCenterIdAndStatusAndLogisticChainType(Integer centerId,
                                                                                           Integer vendorId,
                                                                                           Integer status,
                                                                                           Integer logisticChainType) {
        return productRepository
                .getAllByCenterIdAndVendorIdAndStatusAndLogisticChainType(centerId, vendorId, status, logisticChainType);
    }

    /**
     * Retrieves, page by page, all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId          identifier for the center
     * @param vendorId          identifier for the vendor
     * @param status            status of the products to be fetched. Default value is 1
     * @param logisticChainType logistic chain type of the products to be fetched. Default value is 1
     * @param page              requested page number
     * @param size              size of the requested page
     * @return
     */
    public Page<Product> getProductsByVendorIdAndCenterIdAndStatusAndLogisticChainType(Integer centerId,
                                                                                       Integer vendorId, Integer status,
                                                                                       Integer logisticChainType,
                                                                                       Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return productRepository
                .getAllByCenterIdAndVendorIdAndStatusAndLogisticChainType(centerId, vendorId, status, logisticChainType, pageable);
    }

    /**
     * Updates bookmark flag for a particular {@link Product} supplied by a specific {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId     identifier for the center
     * @param vendorId     identifier for the vendor
     * @param productId    identifier for the product
     * @param isBookmarked true if product is marked as bookmark, false otherwise
     */
    public Iterable<Product> updateBookmark(Integer centerId, Integer vendorId, Integer productId, Integer isBookmarked) {
        StoredProcedureResult result = productRepository.updateBookmark(vendorId, centerId, productId, isBookmarked);
        if (result.getErrorCode() == 0) {
            return this.getProductByVendorIdAndCenterIdAndIdAndLogisticChainId(centerId, vendorId, productId, 1);
        } else {
            throw new UpdateProductBookmarkException("Product %d not provided by vendor %d to center %d.", centerId, vendorId, productId);
        }
    }
}
