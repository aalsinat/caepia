package com.caepia.app.api.service.domain;

import com.caepia.app.api.model.domain.PurchasesTrends;
import com.caepia.app.api.repository.domain.PurchasesTrendsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PurchasesTrendsService {
    private final PurchasesTrendsRepository purchasesTrendsRepository;

    /**
     * Retrieves all purchasesTrends {@link PurchasesTrends}s by a particular {@code Vendor} for the provided {@code Center} and  {@code Product}
     * @param centerId     identifier for the center
     * @param vendorId     identifier for the vendor
     * @param productId    identifier for the product
     * @return
     */
    public Iterable<PurchasesTrends> getAllByCenterIdAndVendorIdAndProductId(Integer centerId, Integer vendorId, Integer productId) {
        return purchasesTrendsRepository.getAllByCenterIdAndVendorIdAndProductId(centerId, vendorId, productId);
    }



}
