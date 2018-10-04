package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.model.domain.OrderRow;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "Orders", description = "List of orders resources")
public interface OrderController {

    @ApiOperation(value = "${OrderController.getOrdersByCenterId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of orders for this center", response = OrderHeader.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<OrderHeader>> getOrdersByCenterId(
            @ApiParam(value = "Center identifier", required = true) Integer centerId,
            @ApiParam(value = "Page number, starting from zero") Integer page,
            @ApiParam(value = "Size of requested page") Integer size);

    @ApiOperation(value = "${OrderController.getOrderByOrderId}", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<OrderHeader> getOrderByOrderId(@PathVariable Integer orderId);


    @ApiOperation(value = "${OrderController.getOrdersRowsByOrderId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of row orders for this order", response = OrderRow.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<OrderRow>> getOrdersRowsByOrderId(
            @ApiParam(value = "Order identifier", required = true) Integer orderId,
            @ApiParam(value = "Page number, starting from zero") Integer page,
            @ApiParam(value = "Size of requested page") Integer size);

}