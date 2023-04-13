package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Gearbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearboxRepository extends JpaRepository<Gearbox, Long> {
}
