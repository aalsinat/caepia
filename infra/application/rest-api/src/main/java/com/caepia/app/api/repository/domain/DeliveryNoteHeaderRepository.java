package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.DeliveryNoteHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryNoteHeaderRepository extends JpaRepository<DeliveryNoteHeader, Integer>, DeliveryNoteHeaderManagementRepository {



    /**
     * Query for fetching information about an authorized {@link DeliveryNoteHeader} to a particular {@code Order}}.
     *
     * @param deliveryNotesId identifier for the center
     * @return information about requested product
     */
    public ModelEntity findByDeliveryNoteId(Integer deliveryNotesId);


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


/** List of the methods */
/* Iterable */

    Iterable<ModelEntity> findAllByCenterIdAndStatusOrderByDeliveryNoteDateDesc(Integer centerId, Integer status);
    Iterable<ModelEntity> findAllByCenterIdAndOwnerOrderByDeliveryNoteDateDesc(Integer centerId, Integer owner);
    Iterable<ModelEntity> findAllByCenterIdAndOrderIdOrderByDeliveryNoteDateDesc(Integer centerId, Integer orderId);
    Iterable<ModelEntity> findAllByCenterIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, String deliveryNoteDate);



    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer owner);
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndOrderIdOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer owner, Integer orderId);
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, String deliveryNoteDate);

    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOrderIdOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer orderId);
    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOrderIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer orderId, String deliveryNoteDate);

    Iterable<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndOrderIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer owner, Integer orderId, String deliveryNoteDate);


    Iterable<ModelEntity> findAllByCenterIdAndOwnerAndOrderIdOrderByDeliveryNoteDateDesc(Integer centerId, Integer owner, Integer orderId);
    Iterable<ModelEntity> findAllByCenterIdAndOwnerAndOrderIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer owner, Integer orderId, String deliveryNoteDate);
    Iterable<ModelEntity> findAllByCenterIdAndOwnerAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer owner, String deliveryNoteDate);

    Iterable<ModelEntity> findAllByCenterIdAndOrderIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer orderId, String deliveryNoteDate);


/* pageable */

    Page<ModelEntity> findAllByCenterIdAndStatusOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Pageable page);
    Page<ModelEntity> findAllByCenterIdAndOwnerOrderByDeliveryNoteDateDesc(Integer centerId, Integer owner, Pageable page);
    Page<ModelEntity> findAllByCenterIdAndOrderIdOrderByDeliveryNoteDateDesc(Integer centerId, Integer orderId, Pageable page);
    Page<ModelEntity> findAllByCenterIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, String deliveryNoteDate, Pageable page);



    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer owner, Pageable page);
    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndOrderIdOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer owner, Integer orderId, Pageable page);
    Page<ModelEntity> findAllByCenterIdAndStatusAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, String deliveryNoteDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndStatusAndOrderIdOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer orderId, Pageable page);
    Page<ModelEntity> findAllByCenterIdAndStatusAndOrderIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer orderId, String deliveryNoteDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndStatusAndOwnerAndOrderIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer status, Integer owner, Integer orderId, String deliveryNoteDate, Pageable page);


    Page<ModelEntity> findAllByCenterIdAndOwnerAndOrderIdOrderByDeliveryNoteDateDesc(Integer centerId, Integer owner, Integer orderId, Pageable page);
    Page<ModelEntity> findAllByCenterIdAndOwnerAndOrderIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer owner, Integer orderId, String deliveryNoteDate, Pageable page);
    Page<ModelEntity> findAllByCenterIdAndOwnerAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer owner, String deliveryNoteDate, Pageable page);

    Page<ModelEntity> findAllByCenterIdAndOrderIdAndDeliveryNoteDateGreaterThanEqualOrderByDeliveryNoteDateDesc(Integer centerId, Integer orderId, String deliveryNoteDate, Pageable page);





}
