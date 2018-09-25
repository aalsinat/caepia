package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.model.domain.Product;
import com.caepia.app.api.model.domain.ThirdLevelFamily;
import com.caepia.app.api.model.domain.Vendor;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "Catalog", description = "List of catalog resources")
public interface CatalogController {

    @ApiOperation(value = "${CatalogController.getVendorsByCenterId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of authorized vendors for this center", response = Vendor.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<Vendor>> getVendorsByCenterId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Page number, starting from zero") Integer page,
            @ApiParam(value = "Size of requested page") Integer size);

    @ApiOperation(value = "${CatalogController.getVendorByCenterId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vendor information", response = Vendor.class),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)
    })
    ResponseEntity<Vendor> getVendorByCenterId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId);

    @ApiOperation(value = "${CatalogController.getVendorFamilies}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of families for a particular vendor", response = ThirdLevelFamily.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ThirdLevelFamily>> getVendorFamilies(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Page number, starting from zero") Integer page,
            @ApiParam(value = "Size of requested page") Integer size);

    @ApiOperation(value = "${CatalogController.getVendorProducts}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of products for a particular vendor", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<Product>> getVendorProducts(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Page number, starting from zero") Integer page,
            @ApiParam(value = "Size of requested page") Integer size);

    @ApiOperation(value = "${CatalogController.getVendorProduct}", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Product> getVendorProduct(@PathVariable Integer centerId,
                                            @PathVariable Integer vendorId,
                                            @PathVariable Integer productId);

    @ApiOperation(value = "${CatalogController.changeVendorProductBookmark}", httpMethod = "PATCH", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> updateBookmark(@PathVariable Integer centerId,
                                          @PathVariable Integer vendorId,
                                          @PathVariable Integer productId,
                                          @RequestParam(value = "isBookmarked", required = true) Integer isBookmarked);
}
