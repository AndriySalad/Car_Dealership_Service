package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.GearboxType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GearboxTypeServiceImpl implements GearboxTypeService{
    @Override
    public List<GearboxType> getAllGearboxType() {
        return null;
    }

    @Override
    public GearboxType getByIdGearboxType(Long id) {
        return null;
    }

    @Override
    public void addGearboxType(GearboxType gearboxType) {

    }

    @Override
    public void deleteGearboxType(Long id) {

    }

    @Override
    public void patchGearboxType(GearboxType updatedGearboxType, Long id) {

    }
}
