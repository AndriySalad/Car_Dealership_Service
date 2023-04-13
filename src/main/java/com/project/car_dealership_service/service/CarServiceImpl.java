package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.CarRepository;
import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getByIdCar(Long id) {
        return carRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void deleteCar(Long id) {

    }

    @Override
    public void patchCar(Car updatedCar, Long id) {

    }
}
