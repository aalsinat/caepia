package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.ApiError;
import com.caepia.app.api.model.domain.Document;
import com.caepia.app.api.model.domain.ProductUnits;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "Document", description = "List of document resources")
public interface DocumentController {


    @ApiOperation(value = "${DocumentController.getAllDocuments}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of documents", response = Document.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Documents not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<Document>> getAllDocuments();

    @ApiOperation(value = "${DocumentController.getAllProductUnits}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of product units", response = Document.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "Documents not authorized to current user", response = ApiError.class)})
    ResponseEntity<Iterable<ProductUnits>> getAllProductUnits();

}
