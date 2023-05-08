package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.*;
import com.project.car_dealership_service.dto.CarBrandDto;
import com.project.car_dealership_service.dto.EngineDto;
import com.project.car_dealership_service.service.*;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final BodyTypeService bodyTypeService;
    private final CountryService countryService;
    private final CarBrandService carBrandService;
    private final EngineService engineService;
    private final FuelTypeService fuelTypeService;

    @GetMapping("/users")
    public List<User> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/body-type/new")
    public ResponseEntity<ItemCreateResponse> newBodyType(@RequestBody BodyType bodyType){
        return ResponseEntity.ok(bodyTypeService.createBodyType(bodyType));
    }

    @PutMapping("/body-type/update/{id}")
    public ResponseEntity<ItemCreateResponse> updateBodyType(@RequestBody BodyType updatedBodyType, @PathVariable Long id){
        BodyType bodyType = bodyTypeService.getById(id);
        return ResponseEntity.ok(bodyTypeService.updateBodyType(updatedBodyType, bodyType));
    }

    @DeleteMapping("/body-type/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteBodyType(@PathVariable Long id){
        BodyType bodyType = bodyTypeService.getById(id);
        return ResponseEntity.ok(bodyTypeService.deleteBodyType(bodyType));
    }

    @PostMapping("/country/new")
    public ResponseEntity<ItemCreateResponse> newCountry(@RequestBody Country country){
        return ResponseEntity.ok(countryService.createCountry(country));
    }

    @PutMapping("/country/update/{id}")
    public ResponseEntity<ItemCreateResponse> updateCountry(@RequestBody Country country, @PathVariable Long id){
        Country oldCountry = countryService.getById(id);
        return ResponseEntity.ok(countryService.updateCountry(country, oldCountry));
    }

    @DeleteMapping("/country/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteCountry(@PathVariable Long id){
        Country country = countryService.getById(id);
        return ResponseEntity.ok(countryService.deleteCountry(country));
    }

    @PostMapping("/car-brand/new")
    public ResponseEntity<ItemCreateResponse> newCarBrand(@RequestBody CarBrandDto carBrand){
        return ResponseEntity.ok(carBrandService.createCarBrand(carBrand));
    }

    @PutMapping("/car-brand/update/{id}")
    public ResponseEntity<ItemCreateResponse> updateCarBrand(@RequestBody CarBrandDto updatedCarBrand, @PathVariable Long id){
        CarBrand oldCarBrand = carBrandService.getById(id);
        return ResponseEntity.ok(carBrandService.updateCarBrand(updatedCarBrand, oldCarBrand));
    }

    @DeleteMapping("/car-brand/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteCarBrand(@PathVariable Long id){
        CarBrand carBrand = carBrandService.getById(id);
        return ResponseEntity.ok(carBrandService.deleteCarBrand(carBrand));
    }

    @PostMapping("/engine/new")
    public ResponseEntity<ItemCreateResponse> newEngine(@RequestBody EngineDto newEngine){
        return ResponseEntity.ok(engineService.createEngine(newEngine));
    }

    @PutMapping("/engine/update/{id}")
    public ResponseEntity<ItemCreateResponse> updateEngine(@RequestBody EngineDto updatedEngine, @PathVariable Long id){
        Engine oldEngine = engineService.findById(id);
        return ResponseEntity.ok(engineService.updateEngine(updatedEngine, oldEngine));
    }

    @DeleteMapping("/engine/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteEngine(@PathVariable Long id){
        Engine engine = engineService.findById(id);
        return ResponseEntity.ok(engineService.deleteEngine(engine));
    }

    @PostMapping("/fuel-type/new")
    public ResponseEntity<ItemCreateResponse> newFuelType(@RequestBody FuelType fuelType){
        return ResponseEntity.ok(fuelTypeService.createFuelType(fuelType));
    }

    @DeleteMapping("/engine/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteFuelType(@PathVariable Long id){
        FuelType fuelType = fuelTypeService.findById(id);
        return ResponseEntity.ok(fuelTypeService.deleteFuelType(fuelType));
    }
}
