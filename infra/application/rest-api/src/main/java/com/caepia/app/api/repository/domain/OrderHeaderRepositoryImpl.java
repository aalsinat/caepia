package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class OrderHeaderRepositoryImpl implements OrderHeaderManagementRepository {
    @PersistenceContext(unitName = "application")
    private EntityManager entityManager;

    @Override
    public StoredProcedureResult sendOrder(Integer orderId, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("sendOrder")
                                                       .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                                                       .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        query.setParameter(0, orderId).setParameter(1, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                                    .errorCode((Integer) result[0])
                                    .errorMessage(String.valueOf(result[1]))
                                    .build();
    }

    @Override
    public StoredProcedureResult createOrderHeader(Integer costCenter, String orderDate, Integer vendor, String deliveryPlanDate, String comments, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("createOrderHeader")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
        query.setParameter(0, costCenter).setParameter(1, orderDate).setParameter(2, vendor).setParameter(3, deliveryPlanDate).setParameter(4, comments).setParameter(5, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .resultCode((Integer)result[2])
                .build();
    }

    @Override
    public StoredProcedureResult updateOrderHeader(Integer orderId, Integer costCenter, String orderDate, Integer vendor, String deliveryPlanDate, String comments, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("updateOrderHeader")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
        query.setParameter(0, orderId).setParameter(1, costCenter).setParameter(2, orderDate).setParameter(3, vendor).setParameter(4, deliveryPlanDate).setParameter(5, comments).setParameter(6, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .build();
    }


}
