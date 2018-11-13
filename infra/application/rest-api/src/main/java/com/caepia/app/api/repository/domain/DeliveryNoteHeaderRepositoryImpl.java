package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class DeliveryNoteHeaderRepositoryImpl implements DeliveryNoteHeaderManagementRepository {
    @PersistenceContext(unitName = "application")
    private EntityManager entityManager;


    @Override
    public StoredProcedureResult createDeliveryNoteHeader(Integer costCenter, String deliveryNoteDate , Integer vendor, String vendorNumDoc, String vendorDate, String comments, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("createOrderHeader")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
        query.setParameter(0, costCenter).setParameter(1, deliveryNoteDate).setParameter(2, vendor).setParameter(3, vendorNumDoc).setParameter(4, vendorDate).setParameter(5, comments).setParameter(6, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .resultCode((Integer)result[2])
                .build();
    }


}
