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
    public CarBrand createCarBrand(CarBrandDto carBrand) {
        Optional<CarBrand> carBrandCheck = carBrandRepository.findByCarBrandName(carBrand.getName());
        if(carBrandCheck.isPresent()) {
            throw new ItemAlreadyExistsException();
        }
        CarBrand newCarBrand = CarBrand.builder()
                .carBrandName(carBrand.getName())
                .build();
        carBrandRepository.save(newCarBrand);
        return newCarBrand;
    }


    @Override
    public ItemDeleteResponse deleteCarBrand(CarBrand carBrand) {
        carBrandRepository.delete(carBrand);
        return ItemDeleteResponse.builder()
                .message("Марку авто видалено!")
                .build();
    }
}
