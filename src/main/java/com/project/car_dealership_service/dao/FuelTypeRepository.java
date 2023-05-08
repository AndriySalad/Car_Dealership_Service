package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {

    Optional<FuelType> findByFuelTypeName(String name);
}
