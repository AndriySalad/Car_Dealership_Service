package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.FuelType;
import com.project.car_dealership_service.service.FuelTypeService;
import com.project.car_dealership_service.service.FuelTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fuel-type")
public class FuelTypeController {

    private final FuelTypeService fuelTypeService;

    @GetMapping
    public List<FuelType> getAll(){
        return fuelTypeService.getAll();
    }

    @GetMapping("/{id}")
    public FuelType getById(@PathVariable Long id){
        return fuelTypeService.findById(id);
    }
}
