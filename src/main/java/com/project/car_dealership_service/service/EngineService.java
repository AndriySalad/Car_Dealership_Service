package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Country;
import com.project.car_dealership_service.domains.Engine;

import java.util.List;

public interface EngineService {
    List<Engine> getAllEngine();
    Engine getByIdEngine(Long id);
    void addEngine(Engine engine);

    void deleteEngine(Long id);
    void patchEngine(Engine updatedEngine, Long id);
}
