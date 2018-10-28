package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface SalesProductManagementRepository {


    StoredProcedureResult updateSalesProductRow(Integer productionOrderId, Integer rowId, Float quantity, Integer userId);



}
