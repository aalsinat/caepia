package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.dto.DeliveryNoteHeaderDataDTO;
import com.caepia.app.api.dto.DeliveryNoteRowDataDTO;
import com.caepia.app.api.dto.DeliveryNoteHeaderPutDataDTO;


import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderRow;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Api(tags = "DeliveryNotes", description = "List of delivery notes resources")
public interface DeliveryNoteController {

/*
    @ApiOperation(value = "${OrderController.getOrderByOrderId}", httpMethod = "GET",
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ModelEntity> getOrderByOrderId(@PathVariable Integer orderId);

*/

    @ApiOperation(value = "${DeliveryNotes.getDeliveryNotesRowsByDeliveryNoteId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of row orders for this order", response = OrderRow.class,
                         responseContainer = "List"),
            @ApiResponse(code = 403, message = "Orders not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ModelEntity>> getOrdersRowsByOrderId(
            @ApiParam(value = "Order identifier", required = true) Integer orderId,
            @ApiParam(value = "Selected fields") Optional<String> fields,

            @ApiParam(value = "Type filter") Optional<String> type,
            @ApiParam(value = "Category filter") Optional<Integer> categoryL3Id,
            @ApiParam(value = "bookmark filter") Optional<Integer> swBookmark,
            @ApiParam(value = "Page number, starting from zero") Optional<Integer> page,
            @ApiParam(value = "Size of requested page") Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;



    @ApiOperation(value = "${DeliveryNotes.createDeliveryNotesHeader}", httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<StoredProcedureResult> createDeliveryNoteHeader(@ApiParam("DeliveryNote header information") DeliveryNoteHeaderDataDTO order);


    @ApiOperation(value = "${DeliveryNotes.updateDeliveryNotesHeader}", httpMethod = "PATCH",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<StoredProcedureResult> updateDeliveryNotesHeader(@PathVariable Integer deliveryNoteId, @ApiParam("Order header information") DeliveryNoteHeaderPutDataDTO order);

    @ApiOperation(value = "${DeliveryNotes.changeDeliveryNotesStatus}", httpMethod = "PATCH",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<StoredProcedureResult> updateDeliveryNotesStatus(@PathVariable Integer deliveryNoteId,
                                                         @RequestParam(value = "status", required = true) Integer status);


    @ApiOperation(value = "${DeliveryNotes.createDeliveryNotesOrw}", httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<StoredProcedureResult> createDeliveryNoteRow(@ApiParam("DeliveryNote Row information") DeliveryNoteRowDataDTO order);

}
