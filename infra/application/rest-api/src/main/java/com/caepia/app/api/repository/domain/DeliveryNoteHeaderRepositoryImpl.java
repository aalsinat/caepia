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
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("createDeliveryNoteHeader")
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

    @Override
    public StoredProcedureResult updateDeliveryNotesHeader(Integer deliveryNoteId, String deliveryNoteDate, String vendorNumDoc , String vendorDate, Integer sourceOrder, Integer invoice, String comments, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("updateDeliveryNoteHeader")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(6, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN);
        query.setParameter(0, deliveryNoteId).setParameter(1, deliveryNoteDate).setParameter(2, vendorNumDoc).setParameter(3, vendorDate).setParameter(4, sourceOrder).setParameter(5, invoice).setParameter(6, comments).setParameter(7, userId);;
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .build();
    }

    @Override
    public StoredProcedureResult updateDeliveryNotesStatus(Integer deliveryNoteId, Integer status, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("updateDeliveryNotesStatus")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
        query.setParameter(0, deliveryNoteId).setParameter(1, status).setParameter(2, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .build();
    }

}
