package com.caepia.app.api.repository.domain;

import com.caepia.app.api.model.domain.ProductUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUnitsRepository extends JpaRepository<ProductUnits, Integer> {


    Iterable<ProductUnits> findAllByOrderByName();




}
