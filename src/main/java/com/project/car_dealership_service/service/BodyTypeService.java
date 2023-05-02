package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.BodyType;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface BodyTypeService {

    BodyType getById(Long id);
    List<BodyType> getAll();

    ItemCreateResponse createBodyType(BodyType bodyType);
    ItemCreateResponse updateBodyType(BodyType updatedBodyType, BodyType oldBodyType);
    ItemDeleteResponse deleteBodyType(BodyType bodyType);
}
