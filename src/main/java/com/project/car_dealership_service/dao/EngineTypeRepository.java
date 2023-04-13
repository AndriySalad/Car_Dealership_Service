package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.EngineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineTypeRepository extends JpaRepository<EngineType, Long> {
}
