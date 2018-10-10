package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;

@Repository
public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer> {


    /**
     * Query for fetching information about an authorized {@link OrderHeader} to a particular {@code Order}}.
     *
     * @param orderId identifier for the center
     * @return information about requested product
     */
    public OrderHeader findByOrderId(Integer orderId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterId(Integer centerId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndOrderDate(Integer centerId, String orderDate);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param productionOrderId identifier for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndProductionOrderId(Integer centerId, Integer productionOrderId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param productionOrderId identifier for the center
     * @param orderDate identifier for the center
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndProductionOrderIdAndOrderDate(Integer centerId, Integer productionOrderId, String orderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndStatus(Integer centerId, Integer status);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param orderDate identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndStatusAndOrderDate(Integer centerId, Integer status, String orderDate);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndStatusAndProductionOrderId(Integer centerId, Integer status, Integer productionOrderId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param orderDate filter identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndStatusAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer productionOrderId, String orderDate);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndOwner(Integer centerId, Integer owner);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndOwnerAndOrderDate(Integer centerId, Integer owner, String orderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param productionOrderId filter productionOrderId for the order
     * @return a list of authorized {@link OrderHeader}s
     */
    Iterable<OrderHeader> findAllByCenterIdAndOwnerAndProductionOrderId(Integer centerId, Integer owner, Integer productionOrderId);

    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param productionOrderId filter productionOrderId for the order
     * @param orderDate filter orderDate for the order
     * @return a list of authorized {@link OrderHeader}s
     */
    Iterable<OrderHeader> findAllByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer owner, Integer productionOrderId, String orderDate);



    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndStatusAndOwner(Integer centerId, Integer status, Integer owner);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @param orderDate identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndStatusAndOwnerAndOrderDate(Integer centerId, Integer status, Integer owner, String orderDate);


    /**
     * Query for fetching all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner identifier for the order
     * @param productionOrderId identifier for the order
     * @return a list of authorized {@link OrderHeader}s.
     */
    Iterable<OrderHeader> findAllByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId);


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
    Iterable<OrderHeader> findAllByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer owner, Integer productionOrderId, String orderDate);




    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterId(Integer centerId, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndOrderDate(Integer centerId, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndProductionOrderId(Integer centerId, Integer productionOrderId, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndProductionOrderIdAndOrderDate(Integer centerId, Integer productionOrderId, String orderDate, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndOwner(Integer centerId, Integer owner, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndOwnerAndOrderDate(Integer centerId, Integer owner, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param productionOrderId filter productionOrderId for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndOwnerAndProductionOrderId(Integer centerId, Integer owner, Integer productionOrderId, Pageable page);

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
    Page<OrderHeader> findAllByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer owner, Integer productionOrderId, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndStatus(Integer centerId, Integer status, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param orderDate filter for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndStatusAndOrderDate(Integer centerId, Integer status, String orderDate, Pageable page);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndStatusAndProductionOrderId(Integer centerId, Integer status,Integer productionOrderId, Pageable page);

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
    Page<OrderHeader> findAllByCenterIdAndStatusAndProductionOrderIdAndOrderDate(Integer centerId, Integer status,Integer productionOrderId, String orderDate, Pageable page);


    /**
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter identifier for the order
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterIdAndStatusAndOwner(Integer centerId, Integer status, Integer owner,Pageable page);

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
    Page<OrderHeader> findAllByCenterIdAndStatusAndOwnerAndOrderDate(Integer centerId, Integer status, Integer owner, String orderDate, Pageable page);


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
    Page<OrderHeader> findAllByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId ,Pageable page);




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
    Page<OrderHeader> findAllByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId, String orderDate ,Pageable page);


}
