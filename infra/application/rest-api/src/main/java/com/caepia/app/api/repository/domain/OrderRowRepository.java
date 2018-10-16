package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.OrderRow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRowRepository extends JpaRepository<OrderRow, Integer>, OrderRowManagementRepository {


    /**
     * Query for fetching information about an authorized {@link OrderRow} to a particular {@code Order}}.
     *
     * @param orderId identifier for the order
     * @param rowId row number of the order
     * @return information about requested order
     */
    public OrderRow findByOrderIdAndRowId(Integer orderId, Integer rowId);

    /**
     * Query for fetching all authorized {@link OrderRow}s for a particular {@code Center}.
     *
     * @param orderId identifier for the order
     * @return a list of authorized {@link OrderRow}s.
     */
    Iterable<OrderRow> findByOrderId(Integer orderId);

    /**
     * Query for fetching, page by page, all authorizes {@link OrderRow}s for a particular {@code Order}.
     *
     * @param orderId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderRow}s
     */
    Page<OrderRow> findByOrderId(Integer orderId, Pageable page);



    Iterable<OrderRow> getAllByOrderId(Integer orderId);

    /*
        Starting with status filter
     */


    Iterable<OrderRow> getAllByOrderIdAndGetType(Integer orderId, String getType);

    Iterable<OrderRow> getAllByOrderIdAndGetTypeAndCategoryL3Id(Integer orderId, String getType, Integer categoryL3);

    Iterable<OrderRow> getAllByOrderIdAndGetTypeAndCategoryL3IdAndSwBookmark(Integer orderId, String getType, Integer categoryL3, Integer swBookmark);

    Iterable<OrderRow> getAllByOrderIdAndGetTypeAndSwBookmark(Integer orderId, String getType, Integer swBookmark);

    Iterable<OrderRow> getAllByOrderIdAndCategoryL3Id(Integer orderId, Integer categoryL3);

    Iterable<OrderRow> getAllByOrderIdAndCategoryL3IdAndSwBookmark(Integer orderId, Integer categoryL3, Integer swBookmark);

    Iterable<OrderRow> getAllByOrderIdAndSwBookmark(Integer orderId, Integer swBookmark);



    /*
        With pagination
     */

    /*
        Without filters
     */

    Page<OrderRow> getAllByOrderId(Integer orderId, Pageable page);

    Page<OrderRow> getAllByOrderIdAndGetType(Integer orderId, String getType, Pageable page);

    Page<OrderRow> getAllByOrderIdAndGetTypeAndCategoryL3Id(Integer orderId, String getType, Integer categoryL3, Pageable page);

    Page<OrderRow> getAllByOrderIdAndGetTypeAndCategoryL3IdAndSwBookmark(Integer orderId, String getType, Integer categoryL3, Integer swBookmark, Pageable page);

    Page<OrderRow> getAllByOrderIdAndGetTypeAndSwBookmark(Integer orderId, String getType, Integer swBookmark, Pageable page);

    Page<OrderRow> getAllByOrderIdAndCategoryL3Id(Integer orderId, Integer categoryL3, Pageable page);

    Page<OrderRow> getAllByOrderIdAndCategoryL3IdAndSwBookmark(Integer orderId, Integer categoryL3, Integer swBookmark, Pageable page);

    Page<OrderRow> getAllByOrderIdAndSwBookmark(Integer orderId, Integer swBookmark, Pageable page);


}
