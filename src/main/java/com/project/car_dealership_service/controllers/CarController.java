package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.service.CarService;
import com.project.car_dealership_service.service.OrderService;
import com.project.car_dealership_service.service.UserService;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id){
        return carService.getById(id);
    }

    @PostMapping("/{id}/order")
    public ResponseEntity<ItemCreateResponse> createOrder(@PathVariable Long id, Principal principal){
        return ResponseEntity.ok(orderService.createOrder(userService.getByEmail(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()),
                carService.getById(id)));

    }
}
