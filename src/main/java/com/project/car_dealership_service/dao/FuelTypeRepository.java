package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
}
