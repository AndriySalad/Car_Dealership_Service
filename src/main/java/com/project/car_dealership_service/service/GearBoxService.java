package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Gearbox;
import com.project.car_dealership_service.dto.GearboxDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface GearBoxService {

    List<Gearbox> getAll();
    Gearbox getById(Long id);
    ItemCreateResponse createGearbox(GearboxDto gearboxDto);
    ItemCreateResponse updateGearbox(GearboxDto updatedGearbox, Gearbox oldGearbox);
    ItemDeleteResponse deleteGearbox(Gearbox gearbox);
}
