package com.caepia.app.api.repository.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class ProductRepositoryImpl implements ProductManagementRepository {
    @PersistenceContext(unitName = "application")
    private EntityManager entityManager;

    @Override
    public StoredProcedureResult updateBookmark(Integer vendorId, Integer centerId, Integer productId,
                                                Integer isBookmarked) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("updateBookmark")
                                                       .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                                                       .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                                                       .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
                                                       .registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
        query.setParameter(0, vendorId).setParameter(1, centerId).setParameter(2, productId)
             .setParameter(3, isBookmarked);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();


        return StoredProcedureResult.builder()
                                    .errorCode((Integer) result[0])
                                    .errorMessage(String.valueOf(result[1]))
                                    .build();
    }
}
