package com.caepia.app.api.service.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.exception.SendOrderException;
import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import com.caepia.app.api.model.domain.Product;
import com.caepia.app.api.repository.domain.OrderHeaderRepository;
import com.caepia.app.api.repository.domain.OrderRowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
public class OrderService {
    private final OrderHeaderRepository orderHeaderRepository;
    private final OrderRowRepository orderRowRepository;

    private final String ORDERS_ROW = "getAllByOrderId";

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
    public ModelEntity getOrderByOrderId(Integer orderId) {
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


    /**
     * Retrieves, page by page, all authorized {@link OrderRow}s for a particular {@code Order}.
     *
     * @param orderId identifier for the order
     * @param getType     requested getType filter
     * @param categoryL3     requested categoryL3 filter
     * @param swBookmark     requested swBookmark filter
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderRow}s
     */
    public Iterable<OrderRow> getOrdersRowsByOrderId(Integer orderId,
                                                     Optional<String> getType,
                                                     Optional<Integer> categoryL3,
                                                     Optional<Integer> swBookmark,
                                                     Optional<Integer> page,
                                                     Optional<Integer> size)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        StringBuilder methodName = new StringBuilder(ORDERS_ROW);
        List parameters = new ArrayList(Arrays.asList(orderId));

        methodName.append(getType.isPresent() && parameters.add(getType.get()) ? "AndGetType" : "")
                .append(categoryL3.isPresent() && parameters.add(categoryL3.get()) ? "AndCategoryL3Id" : "")
                .append(swBookmark.isPresent() && parameters.add(swBookmark.get()) ? "AndSwBookmark" : "")
                .append(this.isPageRequest(page, size) && parameters
                        .add(PageRequest.of(this.transformDefaultPage(page.get()), size.get())) ? "" : "");

        this.log.debug("Calling repository method: %s", methodName.toString());

        return this.dynamicRepositoryCall(this.orderRowRepository, methodName.toString(), parameters.toArray(new Object[parameters.size()]));


    }


    /**
     * Updates order status for a particular {@link OrderHeader} supplied.
     *
     * @param orderId     identifier for the order
     * @param userId     identifier for the user
     *
     */
    public ModelEntity sendOrder(Integer orderId, Integer userId) {
        StoredProcedureResult result = orderHeaderRepository.sendOrder(orderId, userId);
        if (result.getErrorCode() == 0) {
            return this.getOrderByOrderId(orderId);
        } else {
            throw new SendOrderException("Order %d hasn't been  updated by user %d.", orderId, userId);
        }
    }


    /**
     * Create a new {@link OrderHeader} for a existing center .
     *
     * @param costCenter    identifier for the center
     * @param orderDate   order date
     * @param vendor     identifier for the vendor
     * @param deliveryPlanDate    delivery plan date
     * @param comments  comments
     * @param userId   identifier for the user
     *
     */


    public ModelEntity createOrderHeader(Integer costCenter, String orderDate , Integer vendor, String deliveryPlanDate, String comments, Integer userId) {
        StoredProcedureResult result = orderHeaderRepository.createOrderHeader(costCenter, orderDate, vendor, deliveryPlanDate, comments, userId);
        if (result.getErrorCode() == 0) {
            Integer orderId = result.getResultCode();
            return this.getOrderByOrderId(orderId);
        } else {
            throw new SendOrderException("Order hasn't been created by user %d. ERROR: ", userId, result.getErrorCode());
        }
    }




        /* ------------------------ */
    /*    Support methods       return this.dynamicRepositoryCall(this.productRepository, methodName.toString(), parameters.toArray(new Object[parameters.size()]));*/
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
    Iterable<OrderRow> dynamicRepositoryCall(JpaRepository repository, String methodName, Object... parameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Class<?>[] types = Arrays.asList(parameters).stream()
                .map(this::getClassNameFromParameter)
                .collect(Collectors.toList())
                .toArray(new Class<?>[parameters.length]);
        Method method = repository.getClass().getMethod(methodName, types);

        return (Iterable<OrderRow>) method.invoke(repository, parameters);
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
