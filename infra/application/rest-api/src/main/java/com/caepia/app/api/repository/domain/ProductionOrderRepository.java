package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.ProductionOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, Integer>, ProductionOrderManagementRepository {


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterId(Integer centerId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param prodOrderDate filter for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndProdOrderDateGreaterThanEqual(Integer centerId, String prodOrderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatus(Integer centerId, Integer status);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param prodOrderDate identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndProdOrderDateGreaterThanEqual(Integer centerId, Integer status, String prodOrderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndOwner(Integer centerId, Integer owner);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param prodOrderDate filter orderDate for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndOwnerAndProdOrderDateGreaterThanEqual(Integer centerId, Integer owner, String prodOrderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwner(Integer centerId, Integer status, Integer owner);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @param prodOrderDate identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndProdOrderDateGreaterThanEqual(Integer centerId, Integer status, Integer owner, String prodOrderDate);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterId(Integer centerId, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param prodOrderDate filter for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndProdOrderDateGreaterThanEqual(Integer centerId, String prodOrderDate, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndOwner(Integer centerId, Integer owner, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param prodOrderDate filter orderDate for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndOwnerAndProdOrderDateGreaterThanEqual(Integer centerId, Integer owner, String prodOrderDate, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatus(Integer centerId, Integer status, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param prodOrderDate filter for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndProdOrderDateGreaterThanEqual(Integer centerId, Integer status, String prodOrderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndOwner(Integer centerId, Integer status, Integer owner, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter identifier for the order
     * @param prodOrderDate filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndProdOrderDateGreaterThanEqual(Integer centerId, Integer status, Integer owner, String prodOrderDate, Pageable page);


 // with centerId
/*
    Iterable<ModelEntity> findAllByCenterId(Integer centerId, Integer vendorId);

    Iterable<ModelEntity> findAllByCenterIdAndStatus(Integer centerId, Integer vendorId, Integer status);

    Iterable<ModelEntity> findAllByCenterIdAndStatusAndProdOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, String prodOrderDate);

    Iterable<ModelEntity> findAllByCenterIdAndOwner(Integer centerId, Integer vendorId, Integer owner);

    Iterable<ModelEntity> findAllByCenterIdAndOwnerAndProdOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer owner, String prodOrderDate);

    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwner(Integer centerId, Integer vendorId, Integer status, Integer owner);

    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndProdOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, Integer owner, String prodOrderDate);

    Page<ModelEntity> findAllByCenterId(Integer centerId, Integer vendorId, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndOwner(Integer centerId, Integer vendorId, Integer owner, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndOwnerAndProdOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer owner, String prodOrderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndStatus(Integer centerId, Integer vendorId, Integer status, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndStatusAndProdOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, String prodOrderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndStatusAndOwner(Integer centerId, Integer vendorId, Integer status, Integer owner, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndProdOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, Integer owner, String prodOrderDate, Pageable page);

*/
}
