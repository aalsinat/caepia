package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.dto.OrderHeaderDataDTO;
import com.caepia.app.api.dto.OrderRowDataDTO;
import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderRow;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Api(tags = "Orders", description = "List of orders resources")
public interface OrderController {


    @ApiOperation(value = "${OrderController.getOrderByOrderId}", httpMethod = "GET",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ModelEntity> getOrderByOrderId(@PathVariable Integer orderId);


    @ApiOperation(value = "${OrderController.getOrdersRowsByOrderId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of row orders for this order", response = OrderRow.class,
                         responseContainer = "List"),
            @ApiResponse(code = 403, message = "Orders not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<OrderRow>> getOrdersRowsByOrderId(
            @ApiParam(value = "Order identifier", required = true) Integer orderId,
            @ApiParam(value = "getType") Optional<String> getType,
            @ApiParam(value = "categoryL3") Optional<Integer> categoryL3,
            @ApiParam(value = "swBookmark") Optional<Integer> swBookmark,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;


    @ApiOperation(value = "${OrderController.sendOrder}", httpMethod = "PATCH",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ModelEntity> sendOrder(@PathVariable Integer orderId);

    @ApiOperation(value = "${OrderController.createOrderHeader}", httpMethod = "POST",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ModelEntity> createOrderHeader(@ApiParam("Order information") OrderHeaderDataDTO order);

    @ApiOperation(value = "${OrderController.updateOrderHeader}", httpMethod = "PATCH",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ModelEntity> updateOrderHeader(@PathVariable Integer orderId, @ApiParam("Order information") OrderHeaderDataDTO order);

    @ApiOperation(value = "${OrderController.createOrderRow}", httpMethod = "POST",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ModelEntity> createOrderRow(@PathVariable Integer orderId, @ApiParam("Order row information") OrderRowDataDTO order);

    @ApiOperation(value = "${OrderController.updateOrderRow}", httpMethod = "PATCH",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ModelEntity> updateOrderRow(@PathVariable Integer orderId, @PathVariable Integer rowId, @ApiParam("Order row information") OrderRowDataDTO order);


}
