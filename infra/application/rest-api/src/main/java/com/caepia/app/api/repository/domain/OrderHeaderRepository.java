package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;

@Repository
public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer>, OrderHeaderManagementRepository {


    /**
     * Query for fetching information about an authorized {@link OrderHeader} to a particular {@code Order}}.
     *
     * @param orderId identifier for the center
     * @return information about requested product
     */
    public ModelEntity findByOrderId(Integer orderId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdOrderByOrderDateDesc(Integer centerId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, String orderDate);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param productionOrderId identifier for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndProductionOrderIdOrderByOrderDateDesc(Integer centerId, Integer productionOrderId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param productionOrderId identifier for the center
     * @param orderDate identifier for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndProductionOrderIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer productionOrderId, String orderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusOrderByOrderDateDesc(Integer centerId, Integer status);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param orderDate identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer status, String orderDate);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndProductionOrderIdOrderByOrderDateDesc(Integer centerId, Integer status, Integer productionOrderId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param orderDate filter identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndProductionOrderIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer status, Integer productionOrderId, String orderDate);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndOwnerOrderByOrderDateDesc(Integer centerId, Integer owner);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndOwnerAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer owner, String orderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param productionOrderId filter productionOrderId for the order
     * @return a list of authorized {@link OrderHeader}s
     */
    Iterable<ModelEntity> findAllByCenterIdAndOwnerAndProductionOrderIdOrderByOrderDateDesc(Integer centerId, Integer owner, Integer productionOrderId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param productionOrderId filter productionOrderId for the order
     * @param orderDate filter orderDate for the order
     * @return a list of authorized {@link OrderHeader}s
     */
    Iterable<ModelEntity> findAllByCenterIdAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer owner, Integer productionOrderId, String orderDate);



    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerOrderByOrderDateDesc(Integer centerId, Integer status, Integer owner);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @param orderDate identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer status, Integer owner, String orderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @param productionOrderId identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndProductionOrderIdOrderByOrderDateDesc(Integer centerId, Integer status, Integer owner, Integer productionOrderId);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @param productionOrderId identifier for the order
     * @param orderDate identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer status, Integer owner, Integer productionOrderId, String orderDate);




    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdOrderByOrderDateDesc(Integer centerId, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndProductionOrderIdOrderByOrderDateDesc(Integer centerId, Integer productionOrderId, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndProductionOrderIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer productionOrderId, String orderDate, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndOwnerOrderByOrderDateDesc(Integer centerId, Integer owner, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndOwnerAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer owner, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param productionOrderId filter productionOrderId for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndOwnerAndProductionOrderIdOrderByOrderDateDesc(Integer centerId, Integer owner, Integer productionOrderId, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param productionOrderId filter productionOrderId for the order
     * @param orderDate filter orderDate for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer owner, Integer productionOrderId, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusOrderByOrderDateDesc(Integer centerId, Integer status, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param orderDate filter for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer status, String orderDate, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndProductionOrderIdOrderByOrderDateDesc(Integer centerId, Integer status,Integer productionOrderId, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param orderDate filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndProductionOrderIdAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer status,Integer productionOrderId, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerOrderByOrderDateDesc(Integer centerId, Integer status, Integer owner,Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter identifier for the order
     * @param orderDate filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndOrderDateGreaterThanEqualOrderByOrderDateDesc(Integer centerId, Integer status, Integer owner, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId ,Pageable page);




    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param orderDate filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId, String orderDate ,Pageable page);


 // with centerIdAndVendorId

    Iterable<ModelEntity> findAllByCenterIdAndVendorId(Integer centerId, Integer vendorId);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, String orderDate);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndProductionOrderId(Integer centerId, Integer vendorId, Integer productionOrderId);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndProductionOrderIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer productionOrderId, String orderDate);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndStatus(Integer centerId, Integer vendorId, Integer status);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, String orderDate);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndProductionOrderId(Integer centerId, Integer vendorId, Integer status, Integer productionOrderId);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndProductionOrderIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, Integer productionOrderId, String orderDate);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndOwner(Integer centerId, Integer vendorId, Integer owner);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndOwnerAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer owner, String orderDate);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndOwnerAndProductionOrderId(Integer centerId, Integer vendorId, Integer owner, Integer productionOrderId);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer owner, Integer productionOrderId, String orderDate);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOwner(Integer centerId, Integer vendorId, Integer status, Integer owner);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOwnerAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, Integer owner, String orderDate);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer vendorId, Integer status, Integer owner, Integer productionOrderId);

    Iterable<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, Integer owner, Integer productionOrderId, String orderDate);


    Page<ModelEntity> findAllByCenterIdAndVendorId(Integer centerId, Integer vendorId, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, String orderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndProductionOrderId(Integer centerId, Integer vendorId, Integer productionOrderId, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndProductionOrderIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer productionOrderId, String orderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndOwner(Integer centerId, Integer vendorId, Integer owner, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndOwnerAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer owner, String orderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndOwnerAndProductionOrderId(Integer centerId, Integer vendorId, Integer owner, Integer productionOrderId, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer owner, Integer productionOrderId, String orderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndStatus(Integer centerId, Integer vendorId, Integer status, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, String orderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndProductionOrderId(Integer centerId, Integer vendorId, Integer status,Integer productionOrderId, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndProductionOrderIdAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status,Integer productionOrderId, String orderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOwner(Integer centerId, Integer vendorId, Integer status, Integer owner,Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOwnerAndOrderDateGreaterThanEqual(Integer centerId, Integer vendorId, Integer status, Integer owner, String orderDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndVendorIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer vendorId, Integer status, Integer owner, Integer productionOrderId ,Pageable page);




}
