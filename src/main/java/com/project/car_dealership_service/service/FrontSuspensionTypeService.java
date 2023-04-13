package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.EngineType;
import com.project.car_dealership_service.domains.FrontSuspensionType;

import java.util.List;

public interface FrontSuspensionTypeService {
    List<FrontSuspensionType> getAllFrontSuspensionType();
    FrontSuspensionType getByIdFrontSuspensionType(Long id);
    void addFrontSuspensionType(FrontSuspensionType FrontSuspensionType);

    void deleteFrontSuspensionType(Long id);
    void patchFrontSuspensionType(FrontSuspensionType updatedFrontSuspensionType, Long id);
}
