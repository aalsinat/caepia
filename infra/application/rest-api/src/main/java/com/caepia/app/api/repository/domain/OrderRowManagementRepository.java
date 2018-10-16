package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface OrderRowManagementRepository {

    StoredProcedureResult createOrderRow(Integer orderId, String productName, Integer categoryL3, Integer units, Float packQuantity, Float cost,  String comments, Integer userId);


}
