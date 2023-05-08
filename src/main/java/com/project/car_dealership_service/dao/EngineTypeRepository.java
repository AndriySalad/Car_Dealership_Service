package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.EngineType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EngineTypeRepository extends JpaRepository<EngineType, Long> {

    Optional<EngineType> findByEngineType(String name);
}
