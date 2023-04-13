package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.FuelType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuelTypeServiceImpl implements FuelTypeService{
    @Override
    public List<FuelType> getAllFuelType() {
        return null;
    }

    @Override
    public FuelType getByIdFuelType(Long id) {
        return null;
    }

    @Override
    public void addFuelType(FuelType fuelType) {

    }

    @Override
    public void deleteFuelType(Long id) {

    }

    @Override
    public void patchFuelType(FuelType updatedFuelType, Long id) {

    }
}
