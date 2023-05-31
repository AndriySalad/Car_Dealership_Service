package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Order;
import com.project.car_dealership_service.domains.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getAllByUser(User user);
}
