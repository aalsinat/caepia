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
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    private final Integer RESULT_OK = 0;
    private final String PRODUCTS_BY_VENDOR_AND_CENTER = "getAllByCenterIdAndVendorId";

    private final ProductRepository productRepository;


    /**
     * Retrieves all {@link Product}s supplied by a particular {@code Vendor} for the provided {@code Center}.
     *
     * @param centerId          identifier for the center
     * @param vendorId          identifier for the vendor
     * @param status            status of the products to be fetched
     * @param logisticChainType logistic chain type of the products to be fetched
     * @param page              requested page number
     * @param size              size of the requested page
     * @return list of all products
     */
    public Iterable<Product> getProductsByVendorAndCenter(Integer centerId, Integer vendorId,
                                                          Optional<Integer> status,
                                                          Optional<Integer> logisticChainType,
                                                          Optional<Integer> categoryL3,
                                                          Optional<Integer> isBookmarked,
                                                          Optional<Integer> page,
                                                          Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StringBuilder methodName = new StringBuilder(PRODUCTS_BY_VENDOR_AND_CENTER);
        List parameters = new ArrayList(Arrays.asList(centerId, vendorId));

        methodName.append(status.isPresent() && parameters.add(status.get()) ? "AndStatus" : "")
                  .append(logisticChainType.isPresent() && parameters.add(logisticChainType.get()) ? "AndLogisticChainType" : "")
                  .append(categoryL3.isPresent() && parameters.add(categoryL3.get()) ? "AndCategoryL3Id" : "")
                  .append(isBookmarked.isPresent() && parameters.add(isBookmarked.get()) ? "AndIsBookmarked" : "")
                  .append(this.isPageRequest(page, size) && parameters
                          .add(PageRequest.of(this.transformDefaultPage(page.get()), size.get())) ? "" : "");

        this.log.debug("Calling repository method: %s", methodName.toString());

        return this.dynamicRepositoryCall(this.productRepository, methodName.toString(), parameters.toArray(new Object[parameters.size()]));
    }


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
     * @param centerId  identifier for the center
     * @param vendorId  identifier for the vendor
     * @param productId identifier for the product
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



    /* ------------------------ */
    /*    Support methods       */
    /* ------------------------ */

    /**
     * Dynamic method for requesting repository methods.
     *
     * @param repository Repository used to make the dynamic call
     * @param methodName Name of the method to be called
     * @param parameters Parameters to be passed in to the method
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Iterable<Product> dynamicRepositoryCall(JpaRepository repository, String methodName, Object... parameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Class<?>[] types = Arrays.asList(parameters).stream()
                                       .map(this::getClassNameFromParameter)
                                       .collect(Collectors.toList())
                                       .toArray(new Class<?>[parameters.length]);
        Method method = repository.getClass().getMethod(methodName, types);

        return (Iterable<Product>) method.invoke(repository, parameters);
    }

    /**
     * Given an object it returns its {@link Class}. If implements Pageable interface, its will return this inteface as {@link Class}.
     *
     * @param param object to be requested
     * @return {@link Class} or {@code interface} of the provided object
     */
    private Class<?> getClassNameFromParameter(Object param) {
        return Pageable.class.isAssignableFrom(param.getClass()) ? Pageable.class : param.getClass();
    }

    private boolean isPageRequest(Optional<Integer> page, Optional<Integer> size) {
        return page.isPresent() && size.isPresent();
    }

    private Integer transformDefaultPage(Integer page) {
        return (page-- <= 0 ? page = 0 : page);

    }
}
