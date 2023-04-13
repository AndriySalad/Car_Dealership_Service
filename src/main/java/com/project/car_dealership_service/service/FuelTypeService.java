package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.FrontSuspensionType;
import com.project.car_dealership_service.domains.FuelType;

import java.util.List;

public interface FuelTypeService {
    List<FuelType> getAllFuelType();
    FuelType getByIdFuelType(Long id);
    void addFuelType(FuelType fuelType);

    void deleteFuelType(Long id);
    void patchFuelType(FuelType updatedFuelType, Long id);
}
