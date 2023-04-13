package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountry();
    Country getByIdCountry(Long id);
    void addCountry(Country country);

    void deleteCountry(Long id);
    void patchCountry(Country updatedCountry, Long id);
}
