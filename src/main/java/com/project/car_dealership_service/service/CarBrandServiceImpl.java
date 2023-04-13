package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.CarBrandRepository;
import com.project.car_dealership_service.domains.CarBrand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarBrandServiceImpl implements CarBrandService{

    private final CarBrandRepository carBrandRepository;
    @Override
    public List<CarBrand> getAllCarBrand() {
        return carBrandRepository.findAll();
    }

    @Override
    public CarBrand getByIdCarBrand(Long id) {
        return carBrandRepository.findById(id).orElseThrow(CarBrandNotFoundException::new);
    }

    @Override
    public void addCarBrand(CarBrand carBrand) {
        carBrandRepository.save(carBrand);
    }

    @Override
    public void deleteCarBrand(Long id) {
        CarBrand carBrand = carBrandRepository.findById(id).orElseThrow(CarBrandNotFoundException::new);
        carBrandRepository.delete(carBrand);
    }

    @Override
    public void patchCarBrand(CarBrand updatedCarBrand, Long id) {
        CarBrand carBrand = carBrandRepository.findById(id).orElse(new CarBrand());
        carBrand.setCarBrandName(updatedCarBrand.getCarBrandName());
        carBrand.setCountry(updatedCarBrand.getCountry());
    }
}
