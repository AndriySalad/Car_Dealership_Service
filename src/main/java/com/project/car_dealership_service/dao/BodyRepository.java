package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Body;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyRepository extends JpaRepository<Body, Long> {
}
