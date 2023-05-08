package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.EngineType;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface EngineTypeService {

    List<EngineType> getAll();
    EngineType findById(Long id);
    ItemCreateResponse createEngineType(EngineType engineType);
    ItemCreateResponse updateEngineType(EngineType updatedEngineType, EngineType oldEngineType);
    ItemDeleteResponse deleteEngineType(EngineType engineType);

}
