package com.caepia.app.api.controller.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderControllerImpl extends AbstractController implements OrderController {

    private final OrderService orderService;

    @Override
    @GetMapping(value = "/order/{orderId}/header")
    public ResponseEntity<ModelEntity> getOrderByOrderId(@PathVariable Integer orderId) {
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
            @RequestParam(value = "getType", required = false) Optional<String> getType,
            @RequestParam(value = "categoryL3", required = false) Optional<Integer> categoryL3,
            @RequestParam(value = "swBookmark", required = false) Optional<Integer> swBookmark,
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "size", required = false) Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

     /*   Iterable<OrderRow> orderRows = super.isPageRequest(page, size) ?
                orderService.getOrdersRowsByOrderId(orderId, super.transformDefaultPage(page.get()), size.get()) :
                orderService.getOrdersRowsByOrderId(orderId); */

            Iterable<OrderRow> orderRows = orderService.getOrdersRowsByOrderId(orderId, getType, categoryL3, swBookmark, page, size );
        return ResponseEntity.ok(orderRows);
    }


    @Override
    @PatchMapping(value = "/order/{orderId}/send")
    public ResponseEntity<ModelEntity> sendOrder(@PathVariable Integer orderId) {
        Integer userId = this.getLogedUserId();
        return ResponseEntity.ok(orderService.sendOrder(orderId, userId));

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

    private Integer getLogedUserId() {
        return ((JwtUser) getContext().getAuthentication().getPrincipal()).getUserId();
    }


}






























