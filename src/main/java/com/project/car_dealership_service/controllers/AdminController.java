package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.*;
import com.project.car_dealership_service.dto.CarBrandDto;
import com.project.car_dealership_service.dto.CarDto;
import com.project.car_dealership_service.service.*;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final CarService carService;
    private final OrderService orderService;
    private final CarBrandService carBrandService;

    @GetMapping("/users")
    public List<User> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }


    @PostMapping("/car/new")
    public Car newCar(@RequestPart("data") CarDto carDto, @RequestPart("files")List<MultipartFile> files){
        return carService.createCar(carDto, files);
    }

    @DeleteMapping("/car/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteCar(@PathVariable Long id){
        Car car = carService.getById(id);
        return ResponseEntity.ok(carService.deleteCar(car));
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAll();
    }

    @GetMapping("/orders/{id}")
    public Order getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @PostMapping("/car-brand/new")
    public CarBrand newCarBrand(@RequestBody CarBrandDto carBrand){
        return carBrandService.createCarBrand(carBrand);
    }

    @DeleteMapping("/car-brand/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteCarBrand(@PathVariable Long id){
        CarBrand carBrand = carBrandService.getById(id);
        return ResponseEntity.ok(carBrandService.deleteCarBrand(carBrand));
    }
}
