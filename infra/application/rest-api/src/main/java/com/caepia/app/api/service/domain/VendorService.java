package com.caepia.app.api.service.domain;

import com.caepia.app.api.model.domain.Vendor;
import com.caepia.app.api.repository.domain.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VendorService {
    private final VendorRepository vendorRepository;

    /**
     * Retrieves all authorizes {@link Vendor}s for a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @return
     */
    public Iterable<Vendor> getAllVendorsAuthorizedToProvidedCenter(Integer centerId) {
        return vendorRepository.findAllByCenterId(centerId);
    }

    /**
     * Retrieves, page by page, all authorized {@link Vendor}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link Vendor}s
     */
    public Iterable<Vendor> getAllVendorsAuthorizedToProvidedCenter(Integer centerId, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page.intValue(), size.intValue());
        return vendorRepository.findAllByCenterId(centerId, pageable);
    }

    /**
     * Retrieves information about an authorized {@link Vendor} to a particular {@code Center}
     *
     * @param centerId identifier for the center
     * @param vendorId identifier for the found vendor
     * @return information about requested {@link Vendor}
     */
    public Vendor getAuthorizedVendorToProvidedCenter(Integer centerId, Integer vendorId) {
        return vendorRepository.findByCenterIdAndId(centerId, vendorId);
    }
}
