package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car getByIdCar(Long id);
    void addCar(Car car);

    void deleteCar(Long id);
    void patchCar(Car updatedCar, Long id);
}
