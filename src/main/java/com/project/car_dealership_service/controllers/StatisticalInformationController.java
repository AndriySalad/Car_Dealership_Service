package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.dao.CarRepository;
import com.project.car_dealership_service.dao.OrderRepository;
import com.project.car_dealership_service.dao.UserRepository;
import com.project.car_dealership_service.utils.InfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/statistic")
@RequiredArgsConstructor
@RestController
public class StatisticalInformationController {

    private final CarRepository carRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @GetMapping
    public InfoResponse getStatistic(){
        return InfoResponse.builder()
                .countCars(carRepository.count())
                .countOrders(orderRepository.count())
                .countUsers(userRepository.count())
                .build();
    }
}
