package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
