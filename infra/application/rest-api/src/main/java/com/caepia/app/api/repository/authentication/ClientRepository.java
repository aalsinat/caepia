package com.caepia.app.api.repository.authentication;

import com.caepia.app.api.model.authentication.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}
