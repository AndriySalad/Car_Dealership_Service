package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.CarBrand;
import com.project.car_dealership_service.domains.Country;
import com.project.car_dealership_service.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id){
        return countryService.getById(id);
    }

    @GetMapping("/{id}/car-brands")
    public List<CarBrand> getCarBrands(@PathVariable Long id){
        Country country = countryService.getById(id);
        return countryService.getCarBrandsByCountry(country);
    }
}
