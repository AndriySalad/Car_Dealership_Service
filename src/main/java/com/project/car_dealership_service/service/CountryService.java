package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.CarBrand;
import com.project.car_dealership_service.domains.Country;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface CountryService {

    List<Country> getAll();
    Country getById(Long id);
    ItemCreateResponse createCountry(Country country);
    ItemCreateResponse updateCountry(Country updatedCountry, Country oldCountry);
    ItemDeleteResponse deleteCountry(Country country);
    List<CarBrand> getCarBrandsByCountry(Country country);
}
