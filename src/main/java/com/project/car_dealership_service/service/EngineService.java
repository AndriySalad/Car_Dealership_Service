package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Engine;
import com.project.car_dealership_service.dto.EngineDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface EngineService {

    List<Engine> getAll();
    Engine findById(Long id);
    ItemCreateResponse createEngine(EngineDto engineDto);
    ItemCreateResponse updateEngine(EngineDto updatedEngine, Engine oldEngine);
    ItemDeleteResponse deleteEngine(Engine engine);
}
