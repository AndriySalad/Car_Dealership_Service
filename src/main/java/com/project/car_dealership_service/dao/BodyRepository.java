package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

public interface BodyRepository extends JpaRepository<Body, Long> {
}
