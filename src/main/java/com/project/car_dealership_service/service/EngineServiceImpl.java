package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Engine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EngineServiceImpl implements EngineService{
    @Override
    public List<Engine> getAllEngine() {
        return null;
    }

    @Override
    public Engine getByIdEngine(Long id) {
        return null;
    }

    @Override
    public void addEngine(Engine engine) {

    }

    @Override
    public void deleteEngine(Long id) {

    }

    @Override
    public void patchEngine(Engine updatedEngine, Long id) {

    }
}
