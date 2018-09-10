package com.caepia.app.api.repository.authentication;

import com.caepia.app.api.dto.LoginResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class UserRepositoryImpl implements UserAuthenticationRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public LoginResult signin(String username, String password, Integer version) {
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("signin")
                                                       .registerStoredProcedureParameter(0, String.class, ParameterMode.IN)
                                                       .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                                                       .registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
        query.setParameter(0, username).setParameter(1, password).setParameter(2, version);
        query.execute();
        Object[] result = (Object[]) query.getSingleResult();

        return LoginResult.builder()
                          .errorCode((Integer) result[0])
                          .errorMessage(String.valueOf(result[1]))
                          .build();
    }
}
