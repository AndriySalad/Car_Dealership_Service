package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.FuelType;
import com.project.car_dealership_service.domains.Gearbox;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GearboxServiceImpl implements GearboxService{

    @Override
    public List<Gearbox> getAllGearbox() {
        return null;
    }

    @Override
    public Gearbox getByIdGearbox(Long id) {
        return null;
    }

    @Override
    public void addGearbox(Gearbox gearbox) {

    }

    @Override
    public void deleteGearbox(Long id) {

    }

    @Override
    public void patchGearbox(Gearbox updatedGearbox, Long id) {

    }
}
