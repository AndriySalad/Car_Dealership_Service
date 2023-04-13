package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.GearboxType;
import com.project.car_dealership_service.domains.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();
    Order getByIdOrder(Long id);
    void addOrder(Order order);

    void deleteOrder(Long id);
    void patchOrder(Order updatedOrder, Long id);
}
