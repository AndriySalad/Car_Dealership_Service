package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.EngineType;

import java.util.List;

public interface EngineTypeService {
    List<EngineType> getAllEngineType();
    EngineType getByIdEngineType(Long id);
    void addEngineType(EngineType engineType);

    void deleteEngineType(Long id);
    void patchEngineType(EngineType updatedEngineType, Long id);
}
