package com.caepia.app.api.controller.domain;

import com.caepia.app.api.exception.CenterNotAccessibleException;
import com.caepia.app.api.model.domain.ThirdLevelFamily;
import com.caepia.app.api.model.domain.Vendor;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogControllerImpl extends AbstractController implements CatalogController {

    private final VendorService vendorService;

    /**
     * Get all authorizes {@link Vendor}s for a particular {@code Center}
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
     * @param centerId
     * @param vendorId
     * @return
     */
    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}")
    public ResponseEntity<Vendor> getVendorByCenterId(@PathVariable Integer centerId, @PathVariable Integer vendorId) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        return ResponseEntity.ok(vendorService.getVendorByCenterIdAndVendorId(centerId, vendorId));
    }

    /**
     * @param centerId
     * @param vendorId
     * @param page
     * @param size
     * @return
     */
    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/categoriesL3")
    public ResponseEntity<ThirdLevelFamily> getVendorFamilies(@PathVariable Integer centerId,
                                                              @PathVariable Integer vendorId,
                                                              @RequestParam(value = "page", required = false) Integer page,
                                                              @RequestParam(value = "size", required = false) Integer size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: To be implented
        return null;
    }

    @Override
    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/products")
    public ResponseEntity<String> getVendorProducts(Integer centerId, Integer vendorId, Integer page, Integer size) {
        return null;
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
                                                                          .anyMatch(centerId::equals);
    }


}






























