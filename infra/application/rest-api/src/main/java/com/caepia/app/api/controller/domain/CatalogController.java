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
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Catalog")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogController {

    private final VendorService vendorService;

    @GetMapping(value = "/centers/{centerId}/vendors")
    @ApiOperation("${CatalogController.getVendorsByCenterId}")
    public ResponseEntity<Iterable<Vendor>> getVendorsByCenterId(@ApiParam("Center identifier") @PathVariable Integer centerId) {
        return ResponseEntity.ok(vendorService.getAllVendorsAuthorizedToProvidedCenter(centerId));
    }

}
