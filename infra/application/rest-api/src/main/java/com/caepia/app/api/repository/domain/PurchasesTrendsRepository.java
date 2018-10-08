package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.PurchasesTrends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesTrendsRepository extends JpaRepository<PurchasesTrends, Integer> {


    /**
     * Query for fetching all authorized {@link PurchasesTrends}s for a particular {@code Center}, {@code Vendor} and {@code Product}.
     *
     * @param centerId     identifier for the center
     * @param vendorId     identifier for the vendor
     * @param productId    identifier for the product
     *
     * @return a list of authorized {@link PurchasesTrends}s.
     */
    Iterable<PurchasesTrends> getAllByCenterIdAndVendorIdAndProductId(Integer centerId, Integer vendorId, Integer productId);

}
