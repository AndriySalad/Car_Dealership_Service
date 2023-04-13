package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.BrakingSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrakingSystemRepository extends JpaRepository<BrakingSystem, Long> {
}
