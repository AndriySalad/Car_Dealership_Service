package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
}
