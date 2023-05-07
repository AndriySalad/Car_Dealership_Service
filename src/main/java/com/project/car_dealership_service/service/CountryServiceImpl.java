package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.CountryRepository;
import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.domains.CarBrand;
import com.project.car_dealership_service.domains.Country;
import com.project.car_dealership_service.utils.ItemAlreadyExistsException;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(Long id) {
        return countryRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public ItemCreateResponse createCountry(Country country) {
        Optional<Country> checked = countryRepository.findByCountryName(country.getCountryName());
        if(checked.isPresent()){
            throw new ItemAlreadyExistsException();
        }

        Country newCountry = Country.builder()
                .countryName(country.getCountryName())
                .build();
        countryRepository.save(newCountry);
        return ItemCreateResponse.builder()
                .message("Країна створена!")
                .item(newCountry)
                .build();
    }

    @Override
    public ItemCreateResponse updateCountry(Country updatedCountry, Country oldCountry) {
        Optional<Country> checked = countryRepository.findByCountryName(updatedCountry.getCountryName());
        if(checked.isPresent()){
            throw new ItemAlreadyExistsException();
        }

        oldCountry.setCountryName(updatedCountry.getCountryName());
        countryRepository.save(oldCountry);

        return ItemCreateResponse.builder()
                .message("Країна створена!")
                .item(oldCountry)
                .build();
    }

    @Override
    public ItemDeleteResponse deleteCountry(Country country) {
        countryRepository.delete(country);
        return ItemDeleteResponse.builder()
                .object(country)
                .message("Країну видалено!")
                .build();
    }

    @Override
    public List<CarBrand> getCarBrandsByCountry(Country country) {
        return country.getListCarBrand();
    }
}
