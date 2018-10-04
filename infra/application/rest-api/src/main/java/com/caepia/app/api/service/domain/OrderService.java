package com.caepia.app.api.service.domain;

import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import com.caepia.app.api.repository.domain.OrderHeaderRepository;
import com.caepia.app.api.repository.domain.OrderRowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {
    private final OrderHeaderRepository orderHeaderRepository;
    private final OrderRowRepository orderRowRepository;
    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterId(Integer centerId) {
        return orderHeaderRepository.findAllByCenterId(centerId);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterId(Integer centerId, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterId(centerId, pageable);
    }

    /**
     * Retrieves all {@link OrderHeader}s supplied by a particular {@code Order}.
     *
     * @param orderId identifier for the order
     * @return information about requested product
     */
    public OrderHeader getOrderByOrderId(Integer orderId) {
        return orderHeaderRepository.findByOrderId(orderId);
    }



    /**
     * Retrieves all authorizes {@link OrderRow}s for a particular {@code Order}
     *
     * @param orderId identifier for the order
     * @return
     */
    public Iterable<OrderRow> getOrdersRowsByOrderId(Integer orderId) {
        return orderRowRepository.findByOrderId(orderId);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderRow}s for a particular {@code Order}.
     *
     * @param orderId identifier for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderRow}s
     */
    public Iterable<OrderRow> getOrdersRowsByOrderId(Integer orderId, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderRowRepository.findByOrderId(orderId, pageable);
    }



}
