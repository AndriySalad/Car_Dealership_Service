package com.project.car_dealership_service.service;


import com.project.car_dealership_service.domains.BrakingSystem;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface BrakingSystemService {

    List<BrakingSystem> getAll();
    BrakingSystem getOne(Long id);
    ItemCreateResponse createBrakingSystem(BrakingSystem brakingSystem);
    ItemCreateResponse updateBrakingSystem(BrakingSystem updatedBrakingSystem, BrakingSystem oldBrakingSystem);
    ItemDeleteResponse deleteBrakingSystem(BrakingSystem brakingSystem);
}
