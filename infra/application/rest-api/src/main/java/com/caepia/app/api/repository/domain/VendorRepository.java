package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    public Iterable<Vendor> findAllByCenterId(Integer centerId);
}
