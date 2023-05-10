package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.dto.CarDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface CarService {

    List<Car> getAll();
    Car getById(Long id);
    ItemCreateResponse createCar(CarDto carDto);
    ItemCreateResponse updateCar(CarDto updatedCarDto,Car oldCar);
    ItemDeleteResponse deleteCar(Car car);

}
