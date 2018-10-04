package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
     * Query for fetching, page by page, all authorizes {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link OrderHeader}s
     */
    Page<OrderHeader> findAllByCenterId(Integer centerId, Pageable page);

}
