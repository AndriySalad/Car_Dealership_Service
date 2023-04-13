package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{
    @Override
    public List<Country> getAllCountry() {
        return null;
    }

    @Override
    public Country getByIdCountry(Long id) {
        return null;
    }

    @Override
    public void addCountry(Country country) {

    }

    @Override
    public void deleteCountry(Long id) {

    }

    @Override
    public void patchCountry(Country updatedCountry, Long id) {

    }
}
