package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ModelEntity;

import com.caepia.app.api.model.domain.SalesProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesProductRepository extends JpaRepository<SalesProduct, Integer>{



    /**
     * Query for fetching all authorized {@link SalesProduct}s for a particular {@code Center}.
     *
     * @param productionOrderId identifier for the productionOrder
     * @return a list of authorized {@link SalesProduct}s.
     */
    Iterable<ModelEntity> findAllByProductionOrderId( Integer productionOrderId);

    /**
     * Query for fetching, page by page, all authorizes {@link SalesProduct}s for a particular {@code Center}.
     *
     * @param productionOrderId identifier for the productionOrder
     * @param page     requested page
     * @return a page of authorized {@link SalesProduct}s
     */
    Page<ModelEntity> findAllByProductionOrderId(Integer productionOrderId, Pageable page);


}
