package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface DeliveryNoteRowManagementRepository {

    StoredProcedureResult createDeliveryNoteRow(Integer deliveryNoteId, String productName , Integer categoryL3, Integer units, Float packQuantity, Float cost, String comments, Integer userId);

    StoredProcedureResult updateDeliveryNotesRow(Integer deliveryNoteId, Integer rowId, Float docPackQuantity, String comments, Integer userId);

    StoredProcedureResult issueDeliveryNotesRow(Integer deliveryNoteId, Integer rowId, Float docPackQuantity, Float docQuantity, Float deliveryQuantity, Float amount, Integer swChecked, Integer issueType,String comments, Integer userId);


}
