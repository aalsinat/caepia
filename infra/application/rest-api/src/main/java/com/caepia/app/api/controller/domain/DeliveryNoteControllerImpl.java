package com.caepia.app.api.controller.domain;

import com.caepia.app.api.dto.*;
import com.caepia.app.api.exception.CenterNotAccessibleException;
import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderRow;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.DeliveryNoteService;
import com.caepia.app.api.service.domain.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeliveryNoteControllerImpl extends AbstractController implements DeliveryNoteController {

    private final DeliveryNoteService deliveryNoteService;


    /*
    @Override
    @GetMapping(value = "/deliveryNotes/{deliveryNotesId}/header")
    public ResponseEntity<ModelEntity> getOrderByOrderId(@PathVariable Integer orderId) {
        return ResponseEntity.ok(deliveryNoteService.getOrderByOrderId(orderId));
    }
*/

    /**
     * Get all authorized {@link OrderRow}s for a particular {@code Order}
     *
     * @param deliveryNotesId identifier for the deliveryNote
     * @param page     requested page number
     * @param size     size of requested page
     * @return
     */
    @Override
    @GetMapping(value = "/deliveryNotes/{deliveryNotesId}/rows")
    public ResponseEntity<Iterable<ModelEntity>> getOrdersRowsByOrderId(
            @PathVariable Integer deliveryNotesId,
            @RequestParam(value = "fields", required = false) Optional<String> fields,
            @RequestParam(value = "type", required = false) Optional<String> type,
            @RequestParam(value = "categoryL3", required = false) Optional<Integer> categoryL3Id,
            @RequestParam(value = "swBookmark", required = false) Optional<Integer> swBookmark,
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "size", required = false) Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

            Iterable<ModelEntity> orderRows = deliveryNoteService.getDeliveryNotesRowsByDeliveryNotesId(deliveryNotesId, type, categoryL3Id, swBookmark,  page, size );

        orderRows = fields.isPresent() ? super
                .includeProperties(orderRows, super.getListFromString(fields.get())) : orderRows;
        return ResponseEntity.ok(orderRows);
    }


    @Override
    @PostMapping(value = "/deliveryNotes/header")
    public ResponseEntity<StoredProcedureResult> createDeliveryNoteHeader(@RequestBody DeliveryNoteHeaderDataDTO deliveryNote) {

        Integer userId = this.getLogedUserId();
        Integer costCenter = deliveryNote.getCostCenter();
        String deliveryNoteDate = deliveryNote.getDeliveryNoteDate();
        Integer vendor = deliveryNote.getVendor();
        String vendorNumDoc = deliveryNote.getVendorNumDoc();
        String vendorDate = deliveryNote.getVendorDate();
        String comments = deliveryNote.getComments();
        if (!isEligible(costCenter))
            throw new CenterNotAccessibleException("Center not authorized to current logged in user", costCenter);

        return ResponseEntity.ok(deliveryNoteService.createDeliveryNoteHeader(costCenter, deliveryNoteDate ,vendor,vendorNumDoc, vendorDate, comments, userId));
    }


    @Override
    @PatchMapping(value = "/deliveryNotes/{deliveryNoteId}/header")
    public ResponseEntity<StoredProcedureResult> updateDeliveryNotesHeader(@PathVariable Integer deliveryNoteId, @RequestBody DeliveryNoteHeaderPutDataDTO deliveryNote) {

        Integer userId = this.getLogedUserId();
        String deliveryNoteDate = deliveryNote.getDeliveryNoteDate();
        String vendorNumDoc = deliveryNote.getVendorNumDoc();
        String vendorDate = deliveryNote.getVendorDate();
        Integer sourceOrder = deliveryNote.getSourceOrder();
        Integer invoice = deliveryNote.getInvoice();
        String comments = deliveryNote.getComments();


        return ResponseEntity.ok(deliveryNoteService.updateDeliveryNotesHeader(deliveryNoteId, deliveryNoteDate, vendorNumDoc ,vendorDate,sourceOrder, invoice, comments, userId));


    }


    @Override
    @PatchMapping(value = "/deliveryNotes/{deliveryNoteId}/status")
    public ResponseEntity<StoredProcedureResult> updateDeliveryNotesStatus(@PathVariable Integer deliveryNoteId,
                                                                @RequestParam(value = "status") Integer status) {
        Integer userId = this.getLogedUserId();

        return ResponseEntity.ok(deliveryNoteService.updateDeliveryNotesStatus(deliveryNoteId, status, userId));
    }


    @Override
    @PostMapping(value = "/deliveryNotes/row")
    public ResponseEntity<StoredProcedureResult> createDeliveryNoteRow(@RequestBody DeliveryNoteRowDataDTO deliveryNote) {

        Integer userId = this.getLogedUserId();

        Integer deliveryNoteId = deliveryNote.getDeliveryNoteId();
        String productName = deliveryNote.getProductName();
        Integer categoryL3 = deliveryNote.getCategoryL3();
        Integer units = deliveryNote.getUnits();

        Float packQuantity = deliveryNote.getPackQuantity();

        Float cost = deliveryNote.getCost();

        String comments = deliveryNote.getComments();


        return ResponseEntity.ok(deliveryNoteService.createDeliveryNoteRow(deliveryNoteId, productName ,categoryL3,units, packQuantity, cost, comments, userId));
    }

    @Override
    @PatchMapping(value = "/deliveryNotes/{deliveryNoteId}/row/{rowId}")
    public ResponseEntity<StoredProcedureResult> updateDeliveryNotesRow(@PathVariable Integer deliveryNoteId, @PathVariable Integer rowId, @RequestBody DeliveryNoteRowPutDataDTO deliveryNote) {

        Integer userId = this.getLogedUserId();

        Float docPackQuantity = deliveryNote.getDocPackQuantity();
        String comments = deliveryNote.getComments();


        return ResponseEntity.ok(deliveryNoteService.updateDeliveryNotesRow(deliveryNoteId, rowId, docPackQuantity, comments, userId));


    }

    @Override
    @PatchMapping(value = "/deliveryNotes/{deliveryNoteId}/rowIssue/{rowId}")
    public ResponseEntity<StoredProcedureResult> issueDeliveryNotesRow(@PathVariable Integer deliveryNoteId, @PathVariable Integer rowId, @RequestBody DeliveryNoteRowIssueDataDTO deliveryNote) {

        Integer userId = this.getLogedUserId();

        Float docPackQuantity = deliveryNote.getDocPackQuantity();
        Float docQuantity = deliveryNote.getDocQuantity();
        Float deliveryQuantity = deliveryNote.getDeliveryQuantity();
        Float amount = deliveryNote.getAmount();
        Integer swChecked = deliveryNote.getSwChecked();
        Integer issueType = deliveryNote.getIssueType();
        String comments = deliveryNote.getComments();


        return ResponseEntity.ok(deliveryNoteService.issueDeliveryNotesRow(deliveryNoteId, rowId, docPackQuantity, docQuantity, deliveryQuantity, amount, swChecked, issueType, comments, userId));


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
        return ((JwtUser) getContext().getAuthentication().getPrincipal()).getCenters().stream().map(s -> s.getCostCenter()).anyMatch(centerId::equals);
    }


}






























