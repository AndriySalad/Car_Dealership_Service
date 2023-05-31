package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.dto.CarDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarService {

    List<Car> getAll();
    Car getById(Long id);
    Car createCar(CarDto carDto, List<MultipartFile> files);
    ItemDeleteResponse deleteCar(Car car);

}
