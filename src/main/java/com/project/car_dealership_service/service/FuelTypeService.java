package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.FuelType;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface FuelTypeService {

    List<FuelType> getAll();
    FuelType findById(Long id);
    ItemCreateResponse createFuelType(FuelType fuelType);
    ItemDeleteResponse deleteFuelType(FuelType fuelType);
}
