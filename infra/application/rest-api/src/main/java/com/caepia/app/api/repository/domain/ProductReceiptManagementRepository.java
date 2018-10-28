package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;

public interface ProductReceiptManagementRepository {


    StoredProcedureResult updateProductionOrderRow(Integer productionOrderId, Integer rowId, Float packQuantity, String comments, Integer userId);

   /* StoredProcedureResult updateOrderHeader(Integer orderId, Integer costCenter, String orderDate, Integer vendor, String deliveryPlanDate, String comments, Integer userId);

    StoredProcedureResult copyOrder(Integer orderId, Integer userId);

    StoredProcedureResult cancelOrder(Integer orderId, Integer userId);

    StoredProcedureResult receiveOrder(Integer orderId, Integer userId); */

}
