package com.caepia.app.api.controller.domain;

import com.caepia.app.api.model.domain.Vendor;
import com.caepia.app.api.service.domain.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
     * @param centerId
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/centers/{centerId}/vendors")
    @ApiOperation(value = "${CatalogController.getAuthorizedVendorsToProvidedCenter}")
    public ResponseEntity<Iterable<Vendor>> getAuthorizedVendorsToProvidedCenter(
            @ApiParam(value = "Center identifier", required = true) @PathVariable Integer centerId,
            @ApiParam(value = "Page number, starting from zero") @RequestParam(value = "page", required = false) Integer page,
            @ApiParam(value = "Size of requested page") @RequestParam(value = "size", required = false) Integer size) {

        // TODO: Filter vendor entity properties to return only those requested using field parameter
        Iterable<Vendor> authorizedVendors = isPageRequest(page, size) ?
                                             vendorService.getAllVendorsAuthorizedToProvidedCenter(centerId, page, size) :
                                             vendorService.getAllVendorsAuthorizedToProvidedCenter(centerId);
        return ResponseEntity.ok(authorizedVendors);
    }


    @GetMapping(value = "/centers/{centerId}/vendors/{vendorId}")
    @ApiOperation(value = "${CatalogController.getAuthorizedVendorToProvidedCenter}")
    public ResponseEntity<Vendor> getAuthorizedVendorToProvidedCenter(
            @ApiParam(value = "Center identifier", required = true) @PathVariable Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) @PathVariable Integer vendorId) {
        // TODO: Filter vendor entity properties to return only those requested using field parameter
        return ResponseEntity.ok(vendorService.getAuthorizedVendorToProvidedCenter(centerId, vendorId));

    }


}
