package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface DeliveryNoteHeaderManagementRepository {

    StoredProcedureResult createDeliveryNoteHeader(Integer costCenter, String deliveryNoteDate , Integer vendor, String vendorNumDoc, String vendorDate, String comments, Integer userId);

    StoredProcedureResult updateDeliveryNotesHeader(Integer deliveryNoteId, String deliveryNoteDate, String vendorNumDoc , String vendorDate, Integer sourceOrder, Integer invoice, String comments, Integer userId);

    StoredProcedureResult updateDeliveryNotesStatus(Integer deliveryNoteId, Integer status, Integer userId);

}
