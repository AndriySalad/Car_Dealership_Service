package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Gearbox;

import java.util.List;

public interface GearboxService {
    List<Gearbox> getAllGearbox();
    Gearbox getByIdGearbox(Long id);
    void addGearbox(Gearbox gearbox);

    void deleteGearbox(Long id);
    void patchGearbox(Gearbox updatedGearbox, Long id);
}
