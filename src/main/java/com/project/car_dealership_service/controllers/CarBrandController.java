package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.domains.CarBrand;
import com.project.car_dealership_service.service.CarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car-brand")
public class CarBrandController {

    private final CarBrandService carBrandService;

    @GetMapping
    public List<CarBrand> getAll(){
        return carBrandService.getAll();
    }

    @GetMapping("/{id}")
    public CarBrand getById(@PathVariable Long id){
        return carBrandService.getById(id);
    }

    @GetMapping("/{id}/cars")
    public List<Car> getCars(@PathVariable Long id){
        CarBrand carBrand = carBrandService.getById(id);
        return carBrand.getCars();
    }
}
