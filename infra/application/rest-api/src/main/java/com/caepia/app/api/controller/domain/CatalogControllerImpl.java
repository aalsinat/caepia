package com.caepia.app.api.controller.domain;

import com.caepia.app.api.exception.CenterNotAccessibleException;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.Product;
import com.caepia.app.api.model.domain.ThirdLevelFamily;
import com.caepia.app.api.model.domain.Vendor;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.OrderService;
import com.caepia.app.api.service.domain.ProductService;
import com.caepia.app.api.service.domain.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogControllerImpl extends AbstractController implements CatalogController {

    private final VendorService vendorService;
    private final ProductService productService;
    private final OrderService orderService;

    /**
     * Get all authorized {@link Vendor}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param page     requested page number
     * @param size     size of requested page
     * @return
     */
    @Override
    @GetMapping(value = "/centers/{centerId}/vendors")
    public ResponseEntity<Iterable<Vendor>> getVendorsByCenterId(
            @PathVariable Integer centerId,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        Iterable<Vendor> authorizedVendors = super.isPageRequest(page, size) ?
                                             vendorService.getVendorsByCenterId(centerId, page, size) :
                                             vendorService.getVendorsByCenterId(centerId);
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
                                                                        @RequestParam(value = "page", required = false) Integer page,
                                                                        @RequestParam(value = "size", required = false) Integer size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: To be implented

        Iterable<ThirdLevelFamily> thirdLevelFamilyIterable = super.isPageRequest(page, size) ?
                                                              vendorService
                                                                      .getVendorThirdLevelFamilyByCenterIdAndVendorId(centerId, vendorId, page, size) :
                                                              vendorService
                                                                      .getVendorThirdLevelFamilyByCenterIdAndVendorId(centerId, vendorId);

        return ResponseEntity.ok(thirdLevelFamilyIterable);
    }

    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/products")
    public ResponseEntity<Iterable<Product>> getVendorProducts(@PathVariable Integer centerId,
                                                               @PathVariable Integer vendorId,
                                                               @RequestParam(value = "status", defaultValue = "1") Integer status,
                                                               @RequestParam(value = "logisticChainType", defaultValue = "1") Integer logisticChainType,
                                                               @RequestParam(value = "page", required = false) Integer page,
                                                               @RequestParam(value = "size", required = false) Integer size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        Iterable<Product> products = super.isPageRequest(page, size) ?
                                     productService
                                             .getProductsByVendorIdAndCenterIdAndStatusAndLogisticChainType(centerId, vendorId, status, logisticChainType, page, size) :
                                     productService
                                             .getProductsByVendorIdAndCenterIdAndStatusAndLogisticChainType(centerId, vendorId, status, logisticChainType);
        return ResponseEntity.ok(products);
    }

    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/products/{productId}")
    public ResponseEntity<Product> getVendorProduct(@PathVariable Integer centerId,
                                                    @PathVariable Integer vendorId,
                                                    @PathVariable Integer productId) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        return ResponseEntity.ok(productService
                .getProductByVendorIdAndCenterIdAndIdAndLogisticChainId(centerId, vendorId, productId, 1));
    }

    @Override
    @PatchMapping(value = "/centers/{centerId}/vendors/{vendorId}/products/{productId}")
    public ResponseEntity<Product> updateBookmark(@PathVariable Integer centerId,
                                                  @PathVariable Integer vendorId,
                                                  @PathVariable Integer productId,
                                                  @RequestParam(value = "isBookmarked") Integer isBookmarked) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Check if requested vendor really exists and is authorized to Center.
        return ResponseEntity.ok(productService.updateBookmark(centerId, vendorId, productId, isBookmarked));
    }


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






























