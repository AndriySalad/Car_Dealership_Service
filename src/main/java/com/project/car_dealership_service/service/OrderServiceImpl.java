package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.CarRepository;
import com.project.car_dealership_service.dao.OrderRepository;
import com.project.car_dealership_service.dao.UserRepository;
import com.project.car_dealership_service.domains.*;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Transactional
    @Override
    public Order createOrder(User user, Car car) {

        Order order = Order.builder()
                .car(car)
                .user(user)
                .build();
        orderRepository.save(order);
        List<Order> orderList = user.getListOrder();
        orderList.add(order);
        user.setListOrder(orderList);
        userRepository.save(user);
        orderRepository.save(order);
        car.setOrder(order);
        car.setStatus(AvailableStatus.SOLD);
        carRepository.save(car);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<Order> getAllByUser(User user) {
        return orderRepository.getAllByUser(user);
    }
}
