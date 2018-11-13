package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.DeliveryNoteRow;
import com.caepia.app.api.model.domain.ModelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryNoteRowRepository extends JpaRepository<DeliveryNoteRow, Integer>, DeliveryNoteRowManagementRepository  {



 /* Iterable model */

    /**
     * Query for fetching all authorized {@link DeliveryNoteRow}s for a particular {@code Center}.
     *
     * @param deliveryNotesId identifier for the order
     * @return a list of authorized {@link DeliveryNoteRow}s.
     */
    Iterable<ModelEntity> findAllByDeliveryNoteId(Integer deliveryNotesId);

    Iterable<ModelEntity> findAllByDeliveryNoteIdAndGetType(Integer deliveryNotesId, String type);

    Iterable<ModelEntity> findAllByDeliveryNoteIdAndCategoryL3Id(Integer deliveryNotesId, Integer categoryL3Id);

    Iterable<ModelEntity> findAllByDeliveryNoteIdAndSwBookmark(Integer deliveryNotesId, Integer swBookmark);

    Iterable<ModelEntity> findAllByDeliveryNoteIdAndGetTypeAndCategoryL3Id(Integer deliveryNotesId, String type, Integer categoryL3Id);

    Iterable<ModelEntity> findAllByDeliveryNoteIdAndGetTypeAndSwBookmark(Integer deliveryNotesId, String type, Integer swBookmark);

    Iterable<ModelEntity> findAllByDeliveryNoteIdAndCategoryL3IdAndSwBookmark(Integer deliveryNotesId, Integer categoryL3Id, Integer swBookmark);

    Iterable<ModelEntity> findAllByDeliveryNoteIdAndGetTypeAndCategoryL3IdAndSwBookmark(Integer deliveryNotesId, String type, Integer categoryL3Id, Integer swBookmark);


    /* Pageable model */
    /**
     * Query for fetching, page by page, all authorizes {@link DeliveryNoteRow}s for a particular {@code Order}.
     *
     * @param deliveryNotesId identifier for the center
     * @param page     requested page
     * @return a page of authorized {@link DeliveryNoteRow}s
     */
    Page<ModelEntity> findAllByDeliveryNoteId(Integer deliveryNotesId, Pageable page);

    Page<ModelEntity> findAllByDeliveryNoteIdAndGetType(Integer deliveryNotesId, String type, Pageable page);

    Page<ModelEntity> findAllByDeliveryNoteIdAndCategoryL3Id(Integer deliveryNotesId, Integer categoryL3Id, Pageable page);

    Page<ModelEntity> findAllByDeliveryNoteIdAndSwBookmark(Integer deliveryNotesId, Integer swBookmark, Pageable page);

    Page<ModelEntity> findAllByDeliveryNoteIdAndGetTypeAndCategoryL3Id(Integer deliveryNotesId, String type, Integer categoryL3Id, Pageable page);

    Page<ModelEntity> findAllByDeliveryNoteIdAndGetTypeAndSwBookmark(Integer deliveryNotesId, String type, Integer swBookmark, Pageable page);

    Page<ModelEntity> findAllByDeliveryNoteIdAndCategoryL3IdAndSwBookmark(Integer deliveryNotesId, Integer categoryL3Id, Integer swBookmark, Pageable page);

    Page<ModelEntity> findAllByDeliveryNoteIdAndGetTypeAndCategoryL3IdAndSwBookmark(Integer deliveryNotesId, String type, Integer categoryL3Id, Integer swBookmark, Pageable page);


}
