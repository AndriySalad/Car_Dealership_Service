package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.EngineType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EngineTypeServiceImpl implements EngineTypeService{
    @Override
    public List<EngineType> getAllEngineType() {
        return null;
    }

    @Override
    public EngineType getByIdEngineType(Long id) {
        return null;
    }

    @Override
    public void addEngineType(EngineType engineType) {

    }

    @Override
    public void deleteEngineType(Long id) {

    }

    @Override
    public void patchEngineType(EngineType updatedEngineType, Long id) {

    }
}
