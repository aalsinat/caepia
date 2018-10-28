package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface ProductionOrderManagementRepository {

    StoredProcedureResult changeStatusProductionOrder(Integer productionOrderId, Integer status, Integer userId);

    StoredProcedureResult createProductionOrder(Integer costCenter, Integer userId);



}
