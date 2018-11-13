package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.LogDataDTO;
import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.model.domain.Document;
import com.caepia.app.api.model.domain.ProductUnits;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.DocumentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DocumentControllerImpl extends AbstractController implements DocumentController {

    private final DocumentService documentService;


    /**
     * Get all authorized {@link Document}s
     *
     * @return
     */
    @Override
    @GetMapping(value = "/documents/status")
    public ResponseEntity<Iterable<Document>> getAllDocuments() {

        Iterable<Document> orderRows = documentService.getAllDocuments();
        return ResponseEntity.ok(orderRows);
    }


    /**
     * Get all authorized {@link ProductUnits}s
     *
     * @return
     */
    @Override
    @GetMapping(value = "/documents/productUnits")
    public ResponseEntity<Iterable<ProductUnits>> getAllProductUnits() {

        Iterable<ProductUnits> productUnits = documentService.getAllProductUnits();
        return ResponseEntity.ok(productUnits);
    }

    @Override
    @PostMapping(value = "/documents/log")
    public ResponseEntity<StoredProcedureResult> createLogEntry(@RequestBody LogDataDTO log) {

        Integer userId = this.getLogedUserId();
        Integer logEventType = log.getLogEventType();
        Integer logProces = log.getLogProces();
        String description = log.getDescription();
        String extraInfo = log.getExtraInfo();
        String deviceInfo = log.getDeviceInfo();

        return ResponseEntity.ok(documentService.createLogEntry(logProces, logEventType ,description,extraInfo, deviceInfo, userId));





    }

    // -----------------------------
    //  Class support methods
    // -----------------------------

    /**
     * Checks if provided {@code Center} identifier is eligible considering current logged user security context.
     *
     * @param centerId identifier for the center
     * @return true if center is eligible, false otherwise
     */
    private boolean isEligible(Integer centerId) {
        return ((JwtUser) getContext().getAuthentication().getPrincipal()).getCenters().stream()
                                                                          .map(s -> s.getCostCenter())
                                                                          .anyMatch(centerId::equals);
    }

}






























