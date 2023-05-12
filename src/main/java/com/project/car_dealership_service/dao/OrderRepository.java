package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
