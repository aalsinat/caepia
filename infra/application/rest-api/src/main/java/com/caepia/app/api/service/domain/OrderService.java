package com.caepia.app.api.service.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.exception.SendOrderException;
import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import com.caepia.app.api.model.domain.Product;
import com.caepia.app.api.repository.domain.OrderHeaderRepository;
import com.caepia.app.api.repository.domain.OrderRowRepository;
import com.caepia.app.api.repository.domain.OrderWhatsAppRepository;
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
    private final OrderWhatsAppRepository orderWhatsAppRepository;


    private final String ORDERS_ROW = "getAllByOrderId";
    private final String ORDERS_CENTER_VENDOR = "findAllByCenterIdAndVendorId";

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @return
     */
    public Iterable<ModelEntity> getOrdersByCenterId(Integer centerId) {
        return orderHeaderRepository.findAllByCenterId(centerId);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param orderDate filter for the center
     * @return
     */
    public Iterable<ModelEntity> getOrdersByCenterIdAndOrderDate(Integer centerId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndOrderDateGreaterThanEqual(centerId ,orderDate);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param centerId identifier for the center
     * @return
     */
    public Iterable<ModelEntity> getOrdersByCenterIdAndProductionOrderId(Integer centerId, Integer productionOrderId) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndProductionOrderIdAndOrderDate(Integer centerId, Integer productionOrderId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndProductionOrderIdAndOrderDateGreaterThanEqual(centerId,productionOrderId, orderDate);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param status status for the order
     * @return
     */
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatus(Integer centerId, Integer status) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOrderDate(Integer centerId, Integer status, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOrderDateGreaterThanEqual(centerId, status, orderDate);
    }

    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param status status for the order
     * @return
     */
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndProductionOrderId(Integer centerId, Integer status, Integer productionOrderId) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer productionOrderId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndProductionOrderIdAndOrderDateGreaterThanEqual(centerId, status, productionOrderId, orderDate);
    }


    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param owner owner for the order
     * @return
     */
    public Iterable<ModelEntity> getOrdersByCenterIdAndOwner(Integer centerId, Integer owner) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndOwnerAndOrderDate(Integer centerId, Integer owner, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndOrderDateGreaterThanEqual(centerId, owner, orderDate);
    }


    /**
     * Retrieves all authorizes {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param owner owner for the order
     * @param productionOrderId filter for the order
     * @return
     */
    public Iterable<ModelEntity> getOrdersByCenterIdAndOwnerAndProductionOrderId(Integer centerId, Integer owner, Integer productionOrderId) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer owner, Integer productionOrderId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqual(centerId, owner, productionOrderId, orderDate);
    }


    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<ModelEntity> getOrdersByCenterId(Integer centerId, Integer page, Integer size) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndOrderDate(Integer centerId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndOrderDateGreaterThanEqual(centerId, orderDate, pageable);
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndProductionOrderId(Integer centerId, Integer productionOrderId, Integer page, Integer size) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndProductionOrderIdAndOrderDate(Integer centerId, Integer productionOrderId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndProductionOrderIdAndOrderDateGreaterThanEqual(centerId, productionOrderId, orderDate, pageable);
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndOwner(Integer centerId, Integer owner, Integer page, Integer size) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndOwnerAndOrderDate(Integer centerId, Integer owner, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndOrderDateGreaterThanEqual(centerId, owner, orderDate, pageable);
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndOwnerAndProductionOrderId(Integer centerId, Integer owner, Integer productionOrderId, Integer page, Integer size) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer owner, Integer productionOrderId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqual(centerId, owner, productionOrderId, orderDate, pageable);
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndProductionOrderId(Integer centerId, Integer status, Integer productionOrderId, Integer page, Integer size) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer productionOrderId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndProductionOrderIdAndOrderDateGreaterThanEqual(centerId, status, productionOrderId, orderDate, pageable);
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatus(Integer centerId, Integer status, Integer page, Integer size) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOrderDate(Integer centerId, Integer status, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOrderDateGreaterThanEqual(centerId, status, orderDate, pageable);
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOwner(Integer centerId, Integer status, Integer owner, Integer page, Integer size) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOwner(Integer centerId, Integer status, Integer owner) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOwnerAndOrderDate(Integer centerId, Integer status, Integer owner, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndOrderDateGreaterThanEqual(centerId, status, owner, orderDate, pageable);
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOwnerAndOrderDate(Integer centerId, Integer status, Integer owner, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndOrderDateGreaterThanEqual(centerId, status, owner, orderDate);
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId, Integer page, Integer size) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer owner, Integer productionOrderId, String orderDate, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqual(centerId, status, owner, productionOrderId, orderDate);
    }

    /**
     * Retrieves, page by page, all authorized {@link OrderHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param status identifier for the order
     * @param owner filter owner for the order
     * @return a page of authorized {@link OrderHeader}s
     */
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderId(Integer centerId, Integer status, Integer owner, Integer productionOrderId) {
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
    public Iterable<ModelEntity> getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(Integer centerId, Integer status, Integer owner, Integer productionOrderId, String orderDate) {
        return orderHeaderRepository.findAllByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDateGreaterThanEqual(centerId, status, owner, productionOrderId, orderDate);
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
     * Retrieves all {@link ModelEntity}s supplied by a particular {@code Order}.
     *
     * @param orderId identifier for the order
     * @return information about requested product
     */
    public ModelEntity ordersWhatsAppParams(Integer orderId) {

        return orderWhatsAppRepository.findByOrderId(orderId);
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
     * @param centerId identifier for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link OrderRow}s
     */
    public Iterable<ModelEntity> getOrderHeaderByCenterIdVendorId(Integer centerId, Integer vendorId,
                                                                  Optional<Integer> status,
                                                                  Optional<Integer> owner,
                                                                  Optional<Integer> productionOrderId,
                                                                  Optional<String> orderDate,
                                                                  Optional<Integer> page,
                                                                  Optional<Integer> size)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {


        StringBuilder methodName = new StringBuilder(ORDERS_CENTER_VENDOR);
        List parameters = new ArrayList(Arrays.asList(centerId));

        parameters.add(vendorId);

        methodName.append(status.isPresent() && parameters.add(status.get()) ? "AndStatus" : "")
                .append(owner.isPresent() && parameters.add(owner.get()) ? "AndOwner" : "")
                .append(productionOrderId.isPresent() && parameters.add(productionOrderId.get()) ? "AndProductionOrderId" : "")
                .append(orderDate.isPresent() && parameters.add(orderDate.get()) ? "AndOrderDateGreaterThanEqual" : "")
                .append(this.isPageRequest(page, size) && parameters
                        .add(PageRequest.of(this.transformDefaultPage(page.get()), size.get())) ? "" : "");

        this.log.debug("Calling repository method: %s", methodName.toString());

        return this.dynamicRepositoryCallOrderHeader(this.orderHeaderRepository,methodName.toString(),parameters.toArray(new Object[parameters.size()]));



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
    public StoredProcedureResult sendOrder(Integer orderId, Integer userId) {
        StoredProcedureResult result = orderHeaderRepository.sendOrder(orderId, userId);
        return result;
      /*  if (result.getErrorCode() == 0) {
            return this.getOrderByOrderId(orderId);
        } else {
            throw new SendOrderException("Order %d hasn't been  updated by user %d.", orderId, userId);
        }
        */
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


    public StoredProcedureResult createOrderHeader(Integer costCenter, String orderDate , Integer vendor, String deliveryPlanDate, String comments, Integer userId) {
        StoredProcedureResult result = orderHeaderRepository.createOrderHeader(costCenter, orderDate, vendor, deliveryPlanDate, comments, userId);
        return result;
       /* if (result.getErrorCode() == 0) {
            Integer orderId = result.getResultCode();
            return this.getOrderByOrderId(orderId);
        } else {
            throw new SendOrderException("Order hasn't been created by user %d. ERROR: ", userId, result.getErrorCode());
        } */
    }

    public StoredProcedureResult updateOrderHeader(Integer orderId, Integer costCenter, String orderDate , Integer vendor, String deliveryPlanDate, String comments, Integer userId) {
        StoredProcedureResult result = orderHeaderRepository.updateOrderHeader(orderId, costCenter, orderDate, vendor, deliveryPlanDate, comments, userId);
        return result;
        /*  if (result.getErrorCode() == 0) {
            return this.getOrderByOrderId(orderId);
        } else {
            throw new SendOrderException("Order hasn't been created by user %d. ERROR: ", userId, result.getErrorCode());
        } */
    }


    public StoredProcedureResult createOrderRow(Integer orderId, String productName, Integer categoryL3, Integer units, Float packQuantity, Float cost,  String comments, Integer userId) {
        StoredProcedureResult result = orderRowRepository.createOrderRow(orderId, productName, categoryL3, units, packQuantity, cost,  comments, userId);
        return result;
       /* if (result.getErrorCode() == 0) {
            Integer rowId = result.getResultCode();
            return orderRowRepository.findByOrderIdAndRowId(orderId,rowId);
        } else {
            throw new SendOrderException("Order hasn't been created by user %d. ERROR: ", userId, result.getErrorCode());
        } */
    }

    public StoredProcedureResult updateOrderRow(Integer orderId, Integer rowId, Float packQuantity, String comments, Integer userId) {
        StoredProcedureResult result = orderRowRepository.updateOrderRow(orderId, rowId, packQuantity,  comments, userId);
        return result;
         /*  if (result.getErrorCode() == 0) {
            return orderRowRepository.findByOrderIdAndRowId(orderId,rowId);
        } else {
            throw new SendOrderException("Order hasn't been created by user %d. ERROR: ", userId, result.getErrorCode());
        } */
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


    Iterable<ModelEntity> dynamicRepositoryCallOrderHeader(JpaRepository repository, String methodName, Object... parameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Class<?>[] types = Arrays.asList(parameters).stream()
                .map(this::getClassNameFromParameter)
                .collect(Collectors.toList())
                .toArray(new Class<?>[parameters.length]);
        Method method = repository.getClass().getMethod(methodName, types);

        return (Iterable<ModelEntity>) method.invoke(repository, parameters);
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
