package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.DeliveryNoteHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryNoteHeaderRepository extends JpaRepository<DeliveryNoteHeader, Integer> {



    /**
     * Query for fetching, page by page, all authorizes {@link DeliveryNoteHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link DeliveryNoteHeader}s
     */
    Page<ModelEntity> findAllByCenterIdOrderByDeliveryNoteDateDesc(Integer centerId, Pageable page);

    /**
     * Query for fetching all authorized {@link DeliveryNoteHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @return a list of authorized {@link DeliveryNoteHeader}s.
     */
    Iterable<ModelEntity> findAllByCenterIdOrderByDeliveryNoteDateDesc(Integer centerId);




}
