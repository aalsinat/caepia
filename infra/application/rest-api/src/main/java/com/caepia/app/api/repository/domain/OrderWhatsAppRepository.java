package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.OrderWhatsApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderWhatsAppRepository extends JpaRepository<OrderWhatsApp, Integer> {


    /**
     * Query for fetching information about an authorized {@link OrderWhatsApp} to a particular {@code OrderWhatsApp}}.
     *
     * @param orderId identifier for the center
     * @return information about requested product
     */
    public ModelEntity findByOrderId(Integer orderId);





}
