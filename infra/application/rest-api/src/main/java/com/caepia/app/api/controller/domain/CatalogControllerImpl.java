package com.caepia.app.api.controller.domain;

import com.caepia.app.api.exception.CenterNotAccessibleException;
import com.caepia.app.api.model.domain.*;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.OrderService;
import com.caepia.app.api.service.domain.ProductService;
import com.caepia.app.api.service.domain.PurchasesTrendsService;
import com.caepia.app.api.service.domain.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogControllerImpl extends AbstractController implements CatalogController {

    private final VendorService vendorService;
    private final ProductService productService;
    private final OrderService orderService;
    private final PurchasesTrendsService purchasesTrendsService;

    /**
     * Get all authorized {@link Vendor}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param page     requested page number
     * @param size     size of requested page
     * @return list of all authorized {@link Vendor}s
     */
    @Override
    @GetMapping(value = "/centers/{centerId}/vendors")
    public ResponseEntity<Iterable<Vendor>> getVendorsByCenterId(
            @PathVariable Integer centerId,
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "size", required = false) Optional<Integer> size,
            @RequestParam(value = "status", required = false) Integer status) {

        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        Iterable<Vendor> authorizedVendors;

        if (super.isStatusFilter(status)) {
            authorizedVendors = super.isPageRequest(page, size) ?
                    vendorService.getVendorsByCenterIdAndStatus(centerId, status, super
                            .transformDefaultPage(page.get()), size.get()) :
                    vendorService.getVendorsByCenterIdAndStatus(centerId, status);
        } else {
            authorizedVendors = super.isPageRequest(page, size) ?
                    vendorService.getVendorsByCenterId(centerId, super.transformDefaultPage(page.get()), size.get()) :
                    vendorService.getVendorsByCenterId(centerId);

        }
        return ResponseEntity.ok(authorizedVendors);
    }


    /**
     * Get information about a particular {@link Vendor} authorized to a concrete {@code Center}.
     *
     * @param centerId identifier for the center
     * @param vendorId identifier for the vendor
     * @return requested {@link Vendor} information
     */
    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}")
    public ResponseEntity<Vendor> getVendorByCenterId(@PathVariable Integer centerId, @PathVariable Integer vendorId) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        // TODO: Check if requested vendor really exists and is authorized to Center.
        return ResponseEntity.ok(vendorService.getVendorByCenterIdAndVendorId(centerId, vendorId));
    }

    /**
     * Get all {@link ThirdLevelFamily} related to a particular {@link Vendor} authorized to a concrete {@code Center}.
     *
     * @param centerId identifier for the center
     * @param vendorId
     * @param page
     * @param size
     * @return
     */
    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/categoriesL3")
    public ResponseEntity<Iterable<ThirdLevelFamily>> getVendorFamilies(@PathVariable Integer centerId,
                                                                        @PathVariable Integer vendorId,
                                                                        @RequestParam(value = "page",
                                                                                      required = false) Optional<Integer> page,
                                                                        @RequestParam(value = "size",
                                                                                      required = false) Optional<Integer> size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: To be implented

        Iterable<ThirdLevelFamily> thirdLevelFamilyIterable = super.isPageRequest(page, size) ?
                vendorService
                        .getVendorThirdLevelFamilyByCenterIdAndVendorId(centerId, vendorId, super
                                .transformDefaultPage(page.get()), size.get()) :
                vendorService
                        .getVendorThirdLevelFamilyByCenterIdAndVendorId(centerId, vendorId);

        return ResponseEntity.ok(thirdLevelFamilyIterable);
    }

    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/products")
    public ResponseEntity<Iterable<Product>> getVendorProducts(@PathVariable Integer centerId,
                                                               @PathVariable Integer vendorId,
                                                               @RequestParam(value = "status", required = false) Optional<Integer> status,
                                                               @RequestParam(value = "logisticChainType", required = false) Optional<Integer> logisticChainType,
                                                               @RequestParam(value = "categoryL3", required = false) Optional<Integer> categoryL3,
                                                               @RequestParam(value = "isBookmarked", required = false) Optional<Integer> isBookmarked,
                                                               @RequestParam(value = "page", required = false) Optional<Integer> page,
                                                               @RequestParam(value = "size", required = false) Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        return ResponseEntity.ok(productService.getProductsByVendorAndCenter(centerId, vendorId, status, logisticChainType, categoryL3, isBookmarked, page, size));
    }


    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/products/{productId}")
    public ResponseEntity<Iterable<Product>> getVendorProduct(@PathVariable Integer centerId,
                                                              @PathVariable Integer vendorId,
                                                              @PathVariable Integer productId,
                                                              @RequestParam(value = "logisticChainType",
                                                                            required = false) Integer logisticChainType) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter

        Iterable<Product> products;
        if (super.isLogisticChainTypeFilter(logisticChainType)) {
            products = productService
                    .getProductByVendorIdAndCenterIdAndIdAndLogisticChainId(centerId, vendorId, productId, logisticChainType);
        } else {

            products = productService.getProductByVendorIdAndCenterIdAndId(centerId, vendorId, productId);

        }

        return ResponseEntity.ok(products);

    }

    @Override
    @PatchMapping(value = "/centers/{centerId}/vendors/{vendorId}/products/{productId}")
    public ResponseEntity<Iterable<Product>> updateBookmark(@PathVariable Integer centerId,
                                                            @PathVariable Integer vendorId,
                                                            @PathVariable Integer productId,
                                                            @RequestParam(
                                                                    value = "isBookmarked") Integer isBookmarked) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Check if requested vendor really exists and is authorized to Center.
        return ResponseEntity.ok(productService.updateBookmark(centerId, vendorId, productId, isBookmarked));
    }


    /**
     * Get all authorized {@link OrderHeader}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param status   identifier for the order
     * @param page     requested page number
     * @param size     size of requested page
     * @return
     */
    @Override
    @GetMapping(value = "/centers/{centerId}/orders")
    public ResponseEntity<Iterable<OrderHeader>> getOrdersByCenterId(
            @PathVariable Integer centerId,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "owner", required = false) Integer owner,
            @RequestParam(value = "productionOrderId", required = false) Integer productionOrderId,
            @RequestParam(value = "orderDate", required = false) String orderDate,
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "size", required = false) Optional<Integer> size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter


        Iterable<OrderHeader> orders;

        if (super.isStatusFilter(status)) {
            if (super.isOwnerFilter(owner)) {
                if (super.isProductionOrderFilter(productionOrderId)) {
                    if (super.isOrderDateFilter(orderDate)) {
                        orders = super.isPageRequest(page, size) ?
                                orderService
                                        .getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(centerId, status, owner, productionOrderId, orderDate, super
                                                .transformDefaultPage(page.get()), size.get()) :
                                orderService
                                        .getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderIdAndOrderDate(centerId, status, productionOrderId, owner, orderDate);

                    } else {
                        orders = super.isPageRequest(page, size) ?
                                orderService
                                        .getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderId(centerId, status, owner, productionOrderId, super
                                                .transformDefaultPage(page.get()), size.get()) :
                                orderService
                                        .getOrdersByCenterIdAndStatusAndOwnerAndProductionOrderId(centerId, status, productionOrderId, owner);
                    }
                } else {
                    if (super.isOrderDateFilter(orderDate)) {
                        orders = super.isPageRequest(page, size) ?
                                orderService
                                        .getOrdersByCenterIdAndStatusAndOwnerAndOrderDate(centerId, status, owner, orderDate, super
                                                .transformDefaultPage(page.get()), size.get()) :
                                orderService
                                        .getOrdersByCenterIdAndStatusAndOwnerAndOrderDate(centerId, status, owner, orderDate);

                    } else {
                        orders = super.isPageRequest(page, size) ?
                                orderService.getOrdersByCenterIdAndStatusAndOwner(centerId, status, owner, super
                                        .transformDefaultPage(page.get()), size.get()) :
                                orderService.getOrdersByCenterIdAndStatusAndOwner(centerId, status, owner);
                    }
                }
            } else {
                if (super.isProductionOrderFilter(productionOrderId)) {
                    if (super.isOrderDateFilter(orderDate)) {
                        orders = super.isPageRequest(page, size) ?
                                orderService
                                        .getOrdersByCenterIdAndStatusAndProductionOrderIdAndOrderDate(centerId, status, productionOrderId, orderDate, super
                                                .transformDefaultPage(page.get()), size.get()) :
                                orderService
                                        .getOrdersByCenterIdAndStatusAndProductionOrderIdAndOrderDate(centerId, status, productionOrderId, orderDate);

                    } else {
                        orders = super.isPageRequest(page, size) ?
                                orderService
                                        .getOrdersByCenterIdAndStatusAndProductionOrderId(centerId, status, productionOrderId, super
                                                .transformDefaultPage(page.get()), size.get()) :
                                orderService
                                        .getOrdersByCenterIdAndStatusAndProductionOrderId(centerId, status, productionOrderId);
                    }
                } else {
                    if (super.isOrderDateFilter(orderDate)) {
                        orders = super.isPageRequest(page, size) ?
                                orderService.getOrdersByCenterIdAndStatusAndOrderDate(centerId, status, orderDate, super
                                        .transformDefaultPage(page.get()), size.get()) :
                                orderService.getOrdersByCenterIdAndStatusAndOrderDate(centerId, status, orderDate);
                    } else {
                        orders = super.isPageRequest(page, size) ?
                                orderService.getOrdersByCenterIdAndStatus(centerId, status, super
                                        .transformDefaultPage(page.get()), size.get()) :
                                orderService.getOrdersByCenterIdAndStatus(centerId, status);
                    }
                }
            }
        } else {
            if (super.isOwnerFilter(owner)) {
                if (super.isProductionOrderFilter(productionOrderId)) {
                    if (super.isOrderDateFilter(orderDate)) {
                        orders = super.isPageRequest(page, size) ?
                                orderService
                                        .getOrdersByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(centerId, owner, productionOrderId, orderDate, super
                                                .transformDefaultPage(page.get()), size.get()) :
                                orderService
                                        .getOrdersByCenterIdAndOwnerAndProductionOrderIdAndOrderDate(centerId, owner, productionOrderId, orderDate);
                    } else {
                        orders = super.isPageRequest(page, size) ?
                                orderService
                                        .getOrdersByCenterIdAndOwnerAndProductionOrderId(centerId, owner, productionOrderId, super
                                                .transformDefaultPage(page.get()), size.get()) :
                                orderService
                                        .getOrdersByCenterIdAndOwnerAndProductionOrderId(centerId, owner, productionOrderId);
                    }
                } else {
                    if (super.isOrderDateFilter(orderDate)) {
                        orders = super.isPageRequest(page, size) ?
                                orderService.getOrdersByCenterIdAndOwnerAndOrderDate(centerId, owner, orderDate, super
                                        .transformDefaultPage(page.get()), size.get()) :
                                orderService.getOrdersByCenterIdAndOwnerAndOrderDate(centerId, owner, orderDate);

                    } else {
                        orders = super.isPageRequest(page, size) ?
                                orderService.getOrdersByCenterIdAndOwner(centerId, owner, super
                                        .transformDefaultPage(page.get()), size.get()) :
                                orderService.getOrdersByCenterIdAndOwner(centerId, owner);
                    }
                }

            } else {
                if (super.isProductionOrderFilter(productionOrderId)) {
                    if (super.isOrderDateFilter(orderDate)) {
                        orders = super.isPageRequest(page, size) ?
                                orderService
                                        .getOrdersByCenterIdAndProductionOrderIdAndOrderDate(centerId, productionOrderId, orderDate, super
                                                .transformDefaultPage(page.get()), size.get()) :
                                orderService
                                        .getOrdersByCenterIdAndProductionOrderIdAndOrderDate(centerId, productionOrderId, orderDate);
                    } else {
                        orders = super.isPageRequest(page, size) ?
                                orderService.getOrdersByCenterIdAndProductionOrderId(centerId, productionOrderId, super
                                        .transformDefaultPage(page.get()), size.get()) :
                                orderService.getOrdersByCenterIdAndProductionOrderId(centerId, productionOrderId);
                    }
                } else {
                    if (super.isOrderDateFilter(orderDate)) {
                        orders = super.isPageRequest(page, size) ?
                                orderService.getOrdersByCenterIdAndOrderDate(centerId, orderDate, super
                                        .transformDefaultPage(page.get()), size.get()) :
                                orderService.getOrdersByCenterIdAndOrderDate(centerId, orderDate);

                    } else {
                        orders = super.isPageRequest(page, size) ?
                                orderService.getOrdersByCenterId(centerId, super.transformDefaultPage(page.get()), size
                                        .get()) :
                                orderService.getOrdersByCenterId(centerId);
                    }
                }
            }

        }
        return ResponseEntity.ok(orders);
    }


    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/products/{productId}/PurchasesTrends")
    public ResponseEntity<Iterable<PurchasesTrends>> getPurchasesTrendsByCenterIdVendorIdProductId(@PathVariable Integer centerId,
                                                                                                   @PathVariable Integer vendorId,
                                                                                                   @PathVariable Integer productId) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        Iterable<PurchasesTrends> purchasesTrends = purchasesTrendsService
                .getAllByCenterIdAndVendorIdAndProductId(centerId, vendorId, productId);

        return ResponseEntity.ok(purchasesTrends);
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
        return ((JwtUser) getContext().getAuthentication().getPrincipal()).getCenters().stream()
                                                                          .map(s -> s.getCostCenter())
                                                                          .anyMatch(centerId::equals);
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






























