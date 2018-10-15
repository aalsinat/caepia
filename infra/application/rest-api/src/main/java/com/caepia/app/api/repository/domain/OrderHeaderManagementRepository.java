package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface OrderHeaderManagementRepository {
    StoredProcedureResult sendOrder(Integer orderId, Integer userId);
}
