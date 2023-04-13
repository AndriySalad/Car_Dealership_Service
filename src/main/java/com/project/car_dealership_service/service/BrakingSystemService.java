package com.project.car_dealership_service.service;


import com.project.car_dealership_service.domains.BrakingSystem;

import java.util.List;

public interface BrakingSystemService {
    List<BrakingSystem> getAllBrakingSystem();
    BrakingSystem getByIdBrakingSystem(Long id);
    void addBrakingSystem(BrakingSystem brakingSystem);

    void deleteBrakingSystem(Long id);
    void patchBrakingSystem(BrakingSystem updatedBrakingSystem, Long id);
}
