package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public Order getByIdOrder(Long id) {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public void patchOrder(Order updatedOrder, Long id) {

    }
}
