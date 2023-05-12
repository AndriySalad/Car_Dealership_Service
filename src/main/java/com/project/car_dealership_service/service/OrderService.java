package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.domains.Order;
import com.project.car_dealership_service.domains.User;
import com.project.car_dealership_service.utils.ItemCreateResponse;

import java.util.List;

public interface OrderService {

    ItemCreateResponse createOrder(User user, Car car);
    List<Order> getAll();
    Order getById(Long id);
}
