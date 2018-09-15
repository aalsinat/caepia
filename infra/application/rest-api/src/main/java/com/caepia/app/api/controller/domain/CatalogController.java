package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.exception.CenterNotAccessibleException;
import com.caepia.app.api.model.domain.Vendor;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.VendorService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Catalog")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogController extends AbstractController {

    private final VendorService vendorService;

    /**
     * Get all authorizes {@link Vendor}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param page     requested page number
     * @param size     size of requested page
     * @return
     */
    @GetMapping(value = "/centers/{centerId}/vendors")
    @ApiOperation(value = "${CatalogController.getAuthorizedVendorsToProvidedCenter}")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "List of authorized vendors for this center",
                    response = Vendor.class, responseContainer = "List"),
            @ApiResponse(code = 403,
                    message = "Center not authorized to current user",
                    response = ApiError.class)})
    public ResponseEntity<Iterable<Vendor>> getAuthorizedVendorsToProvidedCenter(
            @ApiParam(value = "Center identifier", required = true) @PathVariable Integer centerId,
            @ApiParam(value = "Page number, starting from zero") @RequestParam(value = "page", required = false) Integer page,
            @ApiParam(value = "Size of requested page") @RequestParam(value = "size", required = false) Integer size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        Iterable<Vendor> authorizedVendors = super.isPageRequest(page, size) ?
                                             vendorService
                                                     .getAllVendorsAuthorizedToProvidedCenter(centerId, page, size) :
                                             vendorService.getAllVendorsAuthorizedToProvidedCenter(centerId);
        return ResponseEntity.ok(authorizedVendors);
    }


    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}")
    @ApiOperation(value = "${CatalogController.getAuthorizedVendorToProvidedCenter}")
    public ResponseEntity<Vendor> getAuthorizedVendorToProvidedCenter(
            @ApiParam(value = "Center identifier", required = true) @PathVariable Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) @PathVariable Integer vendorId) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        return ResponseEntity.ok(vendorService.getAuthorizedVendorToProvidedCenter(centerId, vendorId));
    }

    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}/categoriesL3")
    @ApiOperation(value = "${CatalogController.getFamiliesforAuthorizedVendor}")
    public ResponseEntity<String> getFamiliesForAuthorizedVendorToProvidedCenter(
            @ApiParam(value = "Center identifier", required = true) @PathVariable Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) @PathVariable Integer vendorId,
            @ApiParam(value = "Page number, starting from zero") @RequestParam(value = "page", required = false) Integer page,
            @ApiParam(value = "Size of requested page") @RequestParam(value = "size", required = false) Integer size) {
        if (!isEligible(centerId))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", centerId);
        return ResponseEntity.ok("To be implemented");
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






























