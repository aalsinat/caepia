package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class SalesProductRepositoryImpl implements SalesProductManagementRepository {
    @PersistenceContext(unitName = "application")
    private EntityManager entityManager;



    @Override
    public StoredProcedureResult updateSalesProductRow(Integer productionOrderId, Integer rowId, Float packQuantity, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("updateSalesProductRow")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Float.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
        query.setParameter(0, productionOrderId).setParameter(1, rowId).setParameter(2, packQuantity).setParameter(3, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
            //    .resultCode((Integer)result[2])
                .build();
    }
}
