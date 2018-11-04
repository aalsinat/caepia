package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {


    /**
     * Query for fetching all authorized {@link Document}.
     *
     * @return a list of authorized {@link Document}s.
     */
    Iterable<Document> findAllByOrderByStatusId();


}
