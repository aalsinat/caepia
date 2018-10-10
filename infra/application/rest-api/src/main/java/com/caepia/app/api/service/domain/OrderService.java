package com.caepia.app.api.service.domain;

import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import com.caepia.app.api.repository.domain.OrderHeaderRepository;
import com.caepia.app.api.repository.domain.OrderRowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;


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
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOrderDate(Integer centerId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndOrderDate(centerId ,orderDate);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param centerId identifier for the center
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndProductionOrderId(Integer centerId, Integer productionOrderId) {
        return orderHeaderRepository.findAllByCenterIdAndProductionOrderId(centerId,productionOrderId);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param productionOrderId identifier for the center
     * @param orderDate filter for the center
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndProductionOrderIdAndOrderDate(Integer centerId, Integer productionOrderId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndProductionOrderIdAndOrderDate(centerId,productionOrderId, orderDate);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param status status for the order
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatus(Integer centerId, Integer status) {
        return orderHeaderRepository.findAllByCenterIdAndStatus(centerId, status);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param status status for the order
     * @param orderDate status for the order
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOrderDate(Integer centerId, Integer status, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOrderDate(centerId, status, orderDate);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param status status for the order
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndProductionOrderId(Integer centerId, Integer status, Integer productionOrderId) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndProductionOrderId(centerId, status, productionOrderId);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param status status for the order
     * @param orderDate filter for the order
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer productionOrderId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndProductionOrderIdAndOrderDate(centerId, status, productionOrderId, orderDate);
    }


    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param owner owner for the order
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOwner(Integer centerId, Integer owner) {
        return orderHeaderRepository.findAllByCenterIdAndOwner(centerId, owner);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param owner owner for the order
     * @param orderDate filter orderDate for the order
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOwnerAndOrderDate(Integer centerId, Integer owner, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndOrderDate(centerId, owner, orderDate);
    }


    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param owner owner for the order
     * @param productionOrderId filter for the order
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOwnerAndProductionOrderId(Integer centerId, Integer owner, Integer productionOrderId) {
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndProductionOrderId(centerId, owner, productionOrderId);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param owner owner for the order
     * @param productionOrderId filter for the order
     * @param orderDate filter for the order
     * @return
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer owner, Integer productionOrderId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(centerId, owner, productionOrderId, orderDate);
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
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOrderDate(Integer centerId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndOrderDate(centerId, orderDate, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param productionOrderId filter for the center
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndProductionOrderId(Integer centerId, Integer productionOrderId, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndProductionOrderId(centerId, productionOrderId, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param productionOrderId filter for the center
     * @param orderDate filter for the center
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndProductionOrderIdAndOrderDate(Integer centerId, Integer productionOrderId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndProductionOrderIdAndOrderDate(centerId, productionOrderId, orderDate, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOwner(Integer centerId, Integer owner, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndOwner(centerId, owner, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOwnerAndOrderDate(Integer centerId, Integer owner, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndOrderDate(centerId, owner, orderDate, pageable);
    }


    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param owner filter productionOrderId for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOwnerAndProductionOrderId(Integer centerId, Integer owner, Integer productionOrderId, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndProductionOrderId(centerId, owner, productionOrderId, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param owner filter owner for the order
     * @param owner filter productionOrderId for the order
     * @param orderDate filter productionOrderId for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer owner, Integer productionOrderId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(centerId, owner, productionOrderId, orderDate, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndProductionOrderId(Integer centerId, Integer status, Integer productionOrderId, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndProductionOrderId(centerId, status, productionOrderId, pageable);
    }


    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param productionOrderId filter identifier for the order
     * @param orderDate filter identifier for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer productionOrderId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndProductionOrderIdAndOrderDate(centerId, status, productionOrderId, orderDate, pageable);
    }


    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatus(Integer centerId, Integer status, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatus(centerId, status, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param orderDate identifier for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOrderDate(Integer centerId, Integer status, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOrderDate(centerId, status, orderDate, pageable);
    }



    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOwner(Integer centerId, Integer status, Integer owner, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwner(centerId, status, owner, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOwner(Integer centerId, Integer status, Integer owner) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwner(centerId, status, owner);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOwnerAndOrderDate(Integer centerId, Integer status, Integer owner, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndOrderDate(centerId, status, owner, orderDate, pageable);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOwnerAndOrderDate(Integer centerId, Integer status, Integer owner, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndOrderDate(centerId, status, owner, orderDate);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndProductionOrderId(centerId, status, owner, productionOrderId);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer owner, Integer productionOrderId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(centerId, status, owner, productionOrderId, orderDate);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndProductionOrderId(centerId, status, owner, productionOrderId);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @param orderDate filter orderDate for the order
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<OrderHeader> getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer owner, Integer productionOrderId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(centerId, status, owner, productionOrderId, orderDate);
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
