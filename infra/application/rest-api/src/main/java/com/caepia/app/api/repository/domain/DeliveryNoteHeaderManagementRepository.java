package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface DeliveryNoteHeaderManagementRepository {

    StoredProcedureResult createDeliveryNoteHeader(Integer costCenter, String deliveryNoteDate , Integer vendor, String vendorNumDoc, String vendorDate, String comments, Integer userId);



}
