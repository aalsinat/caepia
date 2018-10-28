package com.caepia.app.api.controller.domain;


import com.caepia.app.api.dto.StatusDataDTO;
import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.exception.CenterNotAccessibleException;
import com.caepia.app.api.model.domain.ModelEntity;

import com.caepia.app.api.dto.ProductionOrderRowDataDTO;

import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.ProductionOrderService;
import com.caepia.app.api.service.domain.SalesProductService;
import com.caepia.app.api.service.domain.ProductReceiptService;
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
    private final ProductReceiptService productReceiptService;

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

    /**
     * Get all authorized {@link ModelEntity}s for a particular {@code Center}
     *
     * @param prodOrderId   identifier for the order
     * @param page     requested page number
     * @param size     size of requested page
     * @return
     */
    @Override
    @GetMapping(value = "/productionOrders/{prodOrderId}/products")
    public ResponseEntity<Iterable<ModelEntity>> getProductsByProductionOrders(
            @PathVariable Integer prodOrderId,
            @RequestParam(value = "mode", required = false, defaultValue = "0") Integer mode,
            @RequestParam(value = "fields", required = false) Optional<String> fields,
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "size", required = false) Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Iterable<ModelEntity> listItems;

        if (mode.intValue() == 0) {
            listItems = salesProductService.getSalesProductsByProductionOrders(prodOrderId, page, size);

        }
        else {
            listItems = productReceiptService.getProductsReceiptByProductionOrders(prodOrderId, page, size);
        }



        listItems = fields.isPresent() ? super
                .includeProperties(listItems, super.getListFromString(fields.get())) : listItems;
        return ResponseEntity.ok(listItems);

    }

    @Override
    @PatchMapping(value = "/productionOrders/{productionOrderId}/changeStatus")
    public ResponseEntity<StoredProcedureResult> changeStatusProductionOrder(@PathVariable Integer productionOrderId, @RequestBody StatusDataDTO statusData) {

        Integer userId = this.getLogedUserId();
        Integer status = statusData.getStatus();

        return ResponseEntity.ok(productionOrderService.changeStatusProductionOrder(productionOrderId, status, userId));


    }


    @Override
    @PatchMapping(value = "/productionOrders/{productionOrderId}/product/{rowId}/Row")
    public ResponseEntity<StoredProcedureResult> updateProductionOrderRow(@PathVariable Integer productionOrderId, @PathVariable Integer rowId, @RequestBody ProductionOrderRowDataDTO order) {

        Integer userId = this.getLogedUserId();
        Float packQuantity = order.getQuantity();
        String comments = order.getComments();


        return ResponseEntity.ok(productReceiptService.updateProductionOrderRow(productionOrderId, rowId, packQuantity, comments, userId));


    }

    @Override
    @PatchMapping(value = "/productionOrders/{productionOrderId}/salesProduct/{rowId}/Row")
    public ResponseEntity<StoredProcedureResult> updateSalesProductRow(@PathVariable Integer productionOrderId, @PathVariable Integer rowId, @RequestBody ProductionOrderRowDataDTO order) {

        Integer userId = this.getLogedUserId();
        Float quantity = order.getQuantity();


        return ResponseEntity.ok(salesProductService.updateSalesProductRow(productionOrderId, rowId, quantity, userId));


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

}






























