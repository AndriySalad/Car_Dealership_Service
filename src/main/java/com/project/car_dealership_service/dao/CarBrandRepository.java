package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
    Optional<CarBrand> findByCarBrandName(String carBrandName);
}
