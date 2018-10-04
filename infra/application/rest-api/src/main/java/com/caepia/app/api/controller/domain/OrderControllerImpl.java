package com.caepia.app.api.controller.domain;

import com.caepia.app.api.exception.CenterNotAccessibleException;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderControllerImpl extends AbstractController implements OrderController {

    private final OrderService orderService;
    /**
     * Get all authorized {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param page     requested page number
     * @param size     size of requested page
     * @return
     */
    @Override
    @GetMapping(value = "/centers/{centerId}/orders")
    public ResponseEntity<Iterable<OrderHeader>> getOrdersByCenterId(
            @PathVariable Integer centerId,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        Iterable<OrderHeader> orders = super.isPageRequest(page, size) ?
                                             orderService.getOrdersByCenterId(centerId, page, size) :
                                             orderService.getOrdersByCenterId(centerId);
        return ResponseEntity.ok(orders);
    }

    @Override
    @GetMapping(value = "/order/{orderId}/header")
    public ResponseEntity<OrderHeader> getOrderByOrderId(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.getOrderByOrderId(orderId));
    }


    /**
     * Get all authorized {@link OrderRow}s for a particular {@code Order}
     *
     * @param orderId identifier for the order
     * @param page     requested page number
     * @param size     size of requested page
     * @return
     */
    @Override
    @GetMapping(value = "/order/{orderId}/rows")
    public ResponseEntity<Iterable<OrderRow>> getOrdersRowsByOrderId(
            @PathVariable Integer orderId,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size) {

        Iterable<OrderRow> orderRows = super.isPageRequest(page, size) ?
                orderService.getOrdersRowsByOrderId(orderId, page, size) :
                orderService.getOrdersRowsByOrderId(orderId);
        return ResponseEntity.ok(orderRows);
    }

    // -----------------------------
    //  Class support methods
    // -----------------------------

    /**
     * Checks if provided {@code Center} identifier is eligible considering current logged user security context.
     *
     * @param centerId identifier for the center
     * @return true if center is eligible, false otherwise
     */
    private boolean isEligible(Integer centerId) {
        return ((JwtUser) getContext().getAuthentication().getPrincipal()).getCenters().stream().map(s -> s.getCostCenter()).anyMatch(centerId::equals);
    }

    private Object includeProperties(Object source, List<String> properties) {
        // Create ObjectMapper instance
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Converting POJO to Map
//        Map<String, Object> map = mapper.convertValue(source, new TypeReference<Map<String, Object>>() {
//        });
//
//        //
//        for(Map.Entry<String, Object> entry : map.entrySet()){
//            if(entry.getKey()){
//                System.out.println(entry.getKey() + "-->" + entry.getValue());
//            }
//        }
//        // Convert Map to POJO
//        Object anotherFoo = mapper.convertValue(map, Object.class);
//        return anotherFoo;
        return null;
    }


}






























