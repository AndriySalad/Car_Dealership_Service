package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.CarBrand;

import java.util.List;

public interface CarBrandService {
    List<CarBrand> getAllCarBrand();
    CarBrand getByIdCarBrand(Long id);
    void addCarBrand(CarBrand carBrand);

    void deleteCarBrand(Long id);
    void patchCarBrand(CarBrand updatedCarBrand, Long id);
}
