package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
