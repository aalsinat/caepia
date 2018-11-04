package com.caepia.app.api.service.domain;

import com.caepia.app.api.model.domain.Document;
import com.caepia.app.api.repository.domain.DocumentRepository;


import com.caepia.app.api.model.domain.ProductUnits;
import com.caepia.app.api.repository.domain.ProductUnitsRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final ProductUnitsRepository productUnitsRepository;

    /**
     * Retrieves all authorizes {@link Document}s
     *
     * @return
     */
    public Iterable<Document> getAllDocuments() {
        return documentRepository.findAllByOrderByStatusId();
    }


    /**
     * Retrieves all authorizes {@link ProductUnits}s
     *
     * @return
     */

    public Iterable<ProductUnits> getAllProductUnits() {
        return productUnitsRepository.findAllByOrderByName();
    }
}
