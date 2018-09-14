package com.caepia.app.api.service.domain;

import com.caepia.app.api.model.domain.Vendor;
import com.caepia.app.api.repository.domain.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VendorService {
    private final VendorRepository vendorRepository;

    public Iterable<Vendor> getAllVendorsAuthorizedToProvidedCenter(Integer centerId) {
        return vendorRepository.findAllByCenterId(centerId);
    }
}
