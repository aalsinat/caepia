package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class ProductionOrderRepositoryImpl implements ProductionOrderManagementRepository {
    @PersistenceContext(unitName = "application")
    private EntityManager entityManager;


    @Override
    public StoredProcedureResult changeStatusProductionOrder(Integer productionOrderId, Integer status, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("changeStatus")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
        query.setParameter(0, productionOrderId).setParameter(1, status).setParameter(2, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .build();
    }

    @Override
    public StoredProcedureResult createProductionOrder(Integer costCenter, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("createProductionOrder")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        query.setParameter(0, costCenter).setParameter(1, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .resultCode((Integer)result[2])
                .build();
    }


}
