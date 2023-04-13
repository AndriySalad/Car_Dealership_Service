package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.GearboxType;

import java.util.List;

public interface GearboxTypeService {
    List<GearboxType> getAllGearboxType();
    GearboxType getByIdGearboxType(Long id);
    void addGearboxType(GearboxType gearboxType);

    void deleteGearboxType(Long id);
    void patchGearboxType(GearboxType updatedGearboxType, Long id);
}
