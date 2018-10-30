package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.dto.OrderHeaderDataDTO;
import com.caepia.app.api.dto.ProductionOrderRowDataDTO;
import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.dto.StatusDataDTO;
import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderRow;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Api(tags = "ProductionOrder", description = "List of ProductionOrder resources")
public interface ProductionOrderController {


    @ApiOperation(value = "${CatalogController.getSalesProductsByProductionOrders}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of salesProduct for this center and this productionOrder", response = ModelEntity.class,
                    responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ModelEntity>> getSalesProductsByProductionOrders(
            @ApiParam(value = "Production Order identifier", required = true) Integer prodOrderId,
            @ApiParam(value = "Selected fields") Optional<String> fields,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;


    @ApiOperation(value = "${CatalogController.getProductsByProductionOrders}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of salesProduct for this center and this productionOrder", response = ModelEntity.class,
                    responseContainer = "List"),
            @ApiResponse(code = 403, message = "Center not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ModelEntity>> getProductsByProductionOrders(
            @ApiParam(value = "Production Order identifier", required = true) Integer productionOrderId,
            @ApiParam(value = "mode", required = false, defaultValue = "0") Integer mode,
            @ApiParam(value = "Selected fields") Optional<String> fields,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    @ApiOperation(value = "${ProductionOrder.changeStatusProductionOrder}", httpMethod = "PATCH",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<StoredProcedureResult> changeStatusProductionOrder(@PathVariable Integer productionOrderId, @ApiParam("status information") StatusDataDTO order);


    @ApiOperation(value = "${ProductionOrder.updateProductionOrderRow}", httpMethod = "PATCH",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<StoredProcedureResult> updateProductionOrderRow(@PathVariable Integer productionOrderId, @PathVariable Integer rowId, @ApiParam("Production order Row information") ProductionOrderRowDataDTO order);

    @ApiOperation(value = "${ProductionOrder.updateSalesProductRow}", httpMethod = "PATCH",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<StoredProcedureResult> updateSalesProductRow(@PathVariable Integer productionOrderId, @PathVariable Integer rowId, @ApiParam("Sales Product Row information") ProductionOrderRowDataDTO order);






}
