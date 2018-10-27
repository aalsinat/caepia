package com.caepia.app.api.controller.domain;


import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.exception.CenterNotAccessibleException;
import com.caepia.app.api.model.domain.ModelEntity;

import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.ProductionOrderService;
import com.caepia.app.api.service.domain.SalesProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ProductionOrderControllerImpl extends AbstractController implements ProductionOrderController {

    private final ProductionOrderService productionOrderService;
    private final SalesProductService salesProductService;


    /**
     * Get all authorized {@link ModelEntity}s for a particular {@code Center}
     *
     * @param prodOrderId   identifier for the order
     * @param page     requested page number
     * @param size     size of requested page
     * @return
     */
    @Override
    @GetMapping(value = "/productionOrders/{prodOrderId}/salesProducts")
    public ResponseEntity<Iterable<ModelEntity>> getSalesProductsByProductionOrders(
            @PathVariable Integer prodOrderId,
            @RequestParam(value = "fields", required = false) Optional<String> fields,
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "size", required = false) Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Iterable<ModelEntity> salesProduct = salesProductService.getSalesProductsByProductionOrders(prodOrderId, page, size);

        salesProduct = fields.isPresent() ? super
                .includeProperties(salesProduct, super.getListFromString(fields.get())) : salesProduct;
        return ResponseEntity.ok(salesProduct);




    }

    @Override
    @PostMapping(value = "/centers/{centerId}/productionOrders")
    public ResponseEntity<StoredProcedureResult> createProductionOrder(@PathVariable Integer centerId) {

        Integer userId = this.getLogedUserId();

        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);

        return ResponseEntity.ok(productionOrderService.createProductionOrder(centerId, userId));


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






























