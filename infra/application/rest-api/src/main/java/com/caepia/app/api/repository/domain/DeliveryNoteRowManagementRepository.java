package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface DeliveryNoteRowManagementRepository {

    StoredProcedureResult createDeliveryNoteRow(Integer deliveryNoteId, String productName , Integer categoryL3, Integer units, Float packQuantity, Float cost, String comments, Integer userId);

  //  StoredProcedureResult updateDeliveryNotesHeader(Integer deliveryNoteId, String deliveryNoteDate, String vendorNumDoc, String vendorDate, Integer sourceOrder, Integer invoice, String comments, Integer userId);


}
