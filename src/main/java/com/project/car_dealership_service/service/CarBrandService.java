package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.domains.CarBrand;
import com.project.car_dealership_service.dto.CarBrandDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface CarBrandService {

    List<CarBrand> getAll();
    CarBrand getById(Long id);
    List<Car> getCarByCarBrand(CarBrand carBrand);
    ItemCreateResponse createCarBrand(CarBrandDto carBrand);
    ItemCreateResponse updateCarBrand(CarBrandDto updatedCarBrand, CarBrand oldCarBrand);
    ItemDeleteResponse deleteCarBrand(CarBrand carBrand);
}
