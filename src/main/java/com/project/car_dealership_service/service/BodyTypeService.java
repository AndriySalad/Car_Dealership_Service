package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.BodyType;

import java.util.List;

public interface BodyTypeService {
    List<BodyType> getAllBodyType();
    BodyType getByIdBodyType(Long id);
    void addBodyType(BodyType bodyType);

    void deleteBodyType(Long id);
}
