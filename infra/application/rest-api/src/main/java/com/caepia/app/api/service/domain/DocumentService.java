package com.caepia.app.api.service.domain;

import com.caepia.app.api.model.domain.Document;
import com.caepia.app.api.repository.domain.DocumentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DocumentService {
    private final DocumentRepository documentRepository;

    /**
     * Retrieves all authorizes {@link Document}s
     *
     * @return
     */
    public Iterable<Document> getAllDocuments() {
        return documentRepository.findAll();
    }



}
