package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.GearboxType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearboxTypeRepository extends JpaRepository<GearboxType, Long> {
}
