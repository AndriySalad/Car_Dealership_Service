package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id){
        return carService.getById(id);
    }
}
