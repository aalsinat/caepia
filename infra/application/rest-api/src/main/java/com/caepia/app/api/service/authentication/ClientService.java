package com.caepia.app.api.service.authentication;

import com.caepia.app.api.model.authentication.Client;
import com.caepia.app.api.repository.authentication.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {
    private final ClientRepository clientRepository;

    /**
     * Returns a reference to the client with the given identifier.
     *
     * @param clientId identifier for the client, must not be {@literal null}.
     * @return a reference to the client with the given identifier.
     * @throws javax.persistence.EntityNotFoundException if no entity exists for given {@code id}.
     */
    public Client getById(String clientId) {
        return clientRepository.getOne(clientId);
    }

    /**
     * Returns all instances of {@link Client}.
     *
     * @return all clients
     */
    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }
}
