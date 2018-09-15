package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.model.domain.ThirdLevelFamily;
import com.caepia.app.api.model.domain.Vendor;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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
    ResponseEntity<ThirdLevelFamily> getVendorFamilies(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Page number, starting from zero") Integer page,
            @ApiParam(value = "Size of requested page") Integer size);

    @ApiOperation(value = "${CatalogController.getVendorProducts}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of products for a particular vendor", response = String.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<String> getVendorProducts(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Page number, starting from zero") Integer page,
            @ApiParam(value = "Size of requested page") Integer size);
}
