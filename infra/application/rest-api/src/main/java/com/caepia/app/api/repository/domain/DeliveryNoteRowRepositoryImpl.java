package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class DeliveryNoteRowRepositoryImpl implements DeliveryNoteRowManagementRepository {
    @PersistenceContext(unitName = "application")
    private EntityManager entityManager;


    @Override
    public StoredProcedureResult createDeliveryNoteRow(Integer deliveryNoteId, String productName , Integer categoryL3, Integer units, Float packQuantity, Float cost, String comments, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("createDeliveryNoteRow")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, Float.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, Float.class, ParameterMode.IN)
                .registerStoredProcedureParameter(6, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN);
        query.setParameter(0, deliveryNoteId).setParameter(1, productName).setParameter(2, categoryL3).setParameter(3, units).setParameter(4, packQuantity).setParameter(5, cost).setParameter(6, comments).setParameter(7, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .resultCode((Integer)result[2])
                .build();
    }


    @Override
    public StoredProcedureResult updateDeliveryNotesRow(Integer deliveryNoteId, Integer rowId, Float docPackQuantity, String comments, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("updateDeliveryNoteRow")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Float.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN);
        query.setParameter(0, deliveryNoteId).setParameter(1, rowId).setParameter(2, docPackQuantity).setParameter(3, comments).setParameter(4, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .build();
    }

    @Override
    public StoredProcedureResult issueDeliveryNotesRow(Integer deliveryNoteId, Integer rowId, Float docPackQuantity, Float docQuantity, Float deliveryQuantity, Float amount, Integer swChecked, Integer issueType,String comments, Integer userId) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("issueDeliveryNotesRow")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, Float.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Float.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, Float.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, Float.class, ParameterMode.IN)
                .registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(8, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(9, Integer.class, ParameterMode.IN);
        query.setParameter(0, deliveryNoteId).setParameter(1, rowId).setParameter(2, docPackQuantity).setParameter(3, docQuantity).setParameter(4, deliveryQuantity).setParameter(5, amount).setParameter(6, swChecked).setParameter(7, issueType).setParameter(8, comments).setParameter(9, userId);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                .errorCode((Integer) result[0])
                .errorMessage(String.valueOf(result[1]))
                .build();
    }

}
