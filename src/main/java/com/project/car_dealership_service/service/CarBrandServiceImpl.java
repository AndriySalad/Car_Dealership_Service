package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.CarBrandRepository;
import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.domains.CarBrand;
import com.project.car_dealership_service.dto.CarBrandDto;
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
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository carBrandRepository;
    @Override
    public List<CarBrand> getAll() {
        return carBrandRepository.findAll();
    }

    @Override
    public CarBrand getById(Long id) {
        return carBrandRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<Car> getCarByCarBrand(CarBrand carBrand) {
        return carBrand.getCars();
    }

    @Override
    public ItemCreateResponse createCarBrand(CarBrandDto carBrandDto) {
        Optional<CarBrand> carBrand = carBrandRepository.findByCarBrandName(carBrandDto.getCarBrandName());
        if(carBrand.isPresent()) {
            throw new ItemAlreadyExistsException();
        }
        CarBrand newCarBrand = CarBrand.builder()
                .carBrandName(carBrandDto.getCarBrandName())
                .country(carBrandDto.getCountryName())
                .build();
        carBrandRepository.save(newCarBrand);
        return ItemCreateResponse.builder()
                .message("Марку авто створено!")
                .item(newCarBrand)
                .build();
    }

    @Override
    public ItemCreateResponse updateCarBrand(CarBrandDto updatedCarBrand, CarBrand oldCarBrand) {
        Optional<CarBrand> carBrand = carBrandRepository.findByCarBrandName(updatedCarBrand.getCarBrandName());
        if(carBrand.isPresent()) {
            throw new ItemAlreadyExistsException();
        }
        oldCarBrand.setCarBrandName(updatedCarBrand.getCarBrandName());
        oldCarBrand.setCountry(updatedCarBrand.getCountryName());
        carBrandRepository.save(oldCarBrand);
        return ItemCreateResponse.builder()
                .message("Марку авто відредаговано!")
                .item(oldCarBrand)
                .build();
    }

    @Override
    public ItemDeleteResponse deleteCarBrand(CarBrand carBrand) {
        carBrandRepository.delete(carBrand);
        return ItemDeleteResponse.builder()
                .message("Марку авто видалено!")
                .object(carBrand)
                .build();
    }
}
