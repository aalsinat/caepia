package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.model.domain.*;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Api(tags = "Catalog", description = "List of catalog resources")
public interface CatalogController {

    @ApiOperation(value = "${CatalogController.getVendorsByCenterId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of authorized vendors for this center", response = Vendor.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ModelEntity>> getVendorsByCenterId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Selected fields") Optional<String> fields,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size,
            @ApiParam(value = "Status filter") Integer status);

    @ApiOperation(value = "${CatalogController.getVendorByCenterId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vendor information", response = Vendor.class),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)
    })
    ResponseEntity<Vendor> getVendorByCenterId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Selected fields") Optional<String> fields);

    @ApiOperation(value = "${CatalogController.getVendorFamilies}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of families for a particular vendor", response = ThirdLevelFamily.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ThirdLevelFamily>> getVendorFamilies(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size);

    @ApiOperation(value = "${CatalogController.getVendorProducts}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of products for a particular vendor", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ModelEntity>> getVendorProducts(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Product status") Optional<Integer> status,
            @ApiParam(value = "logisticChainType") Optional<Integer> logisticChainType,
            @ApiParam(value = "categoryL3") Optional<Integer> categoryL3,
            @ApiParam(value = "isBookmarked") Optional<Integer> isBookmarked,
            @ApiParam(value = "Selected fields") Optional<String> fields,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    @ApiOperation(value = "${CatalogController.getVendorProduct}", httpMethod = "GET",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Iterable<ModelEntity>> getVendorProduct(@PathVariable Integer centerId,
                                                       @PathVariable Integer vendorId,
                                                       @PathVariable Integer productId,
                                                       @ApiParam(value = "Selected fields") Optional<String> fields,
                                                       @ApiParam(value = "logisticChainType") Integer logisticChainType);

    @ApiOperation(value = "${CatalogController.changeVendorProductBookmark}", httpMethod = "PATCH",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Iterable<ModelEntity>> updateBookmark(@PathVariable Integer centerId,
                                                     @PathVariable Integer vendorId,
                                                     @PathVariable Integer productId,
                                                     @RequestParam(value = "isBookmarked", required = true) Integer isBookmarked);

    @ApiOperation(value = "${OrderController.getOrdersByCenterId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of orders for this center", response = OrderHeader.class,
                         responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ModelEntity>> getOrdersByCenterId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Selected fields") Optional<String> fields,
            @ApiParam(value = "Status filter") Integer status,
            @ApiParam(value = "Owner filter") Integer owner,
            @ApiParam(value = "ProductionOrderId filter") Integer productionOrderId,
            @ApiParam(value = "OrderData filter") String orderDate,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size);


    @ApiOperation(value = "${OrderController.getOrdersByCenterIdVendorId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of orders for this center", response = OrderHeader.class,
                    responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ModelEntity>> getOrdersByCenterIdVendorId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Selected fields") Optional<String> fields,
            @ApiParam(value = "Status filter") Optional<Integer> status,
            @ApiParam(value = "Owner filter") Optional<Integer> owner,
            @ApiParam(value = "ProductionOrderId filter") Optional<Integer> productionOrderId,
            @ApiParam(value = "OrderData filter") Optional<String> orderDate,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    @ApiOperation(value = "${CatalogController.getPurchasesTrendsByCenterIdVendorIdProductId}",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of authorized PurchasesTrends for this center, vendor and product",
                         response = PurchasesTrends.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<PurchasesTrends>> getPurchasesTrendsByCenterIdVendorIdProductId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Vendor identifier", required = true) Integer vendorId,
            @ApiParam(value = "Product identifier", required = true) Integer productId);


    @ApiOperation(value = "${CatalogController.getProductionOrdersByCenterId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of productionOrders for this center", response = ModelEntity.class,
                    responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ModelEntity>> getProductionOrdersByCenterId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Selected fields") Optional<String> fields,
            @ApiParam(value = "Status filter") Optional<Integer> status,
            @ApiParam(value = "Owner filter") Optional<Integer> owner,
            @ApiParam(value = "OrderData filter") Optional<String> orderDate,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    @ApiOperation(value = "${ProductionOrder.createProductionOrder}", httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<StoredProcedureResult> createProductionOrder(@PathVariable Integer centerId);


}
