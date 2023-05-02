package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Body;
import com.project.car_dealership_service.dto.BodyDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;

import java.util.List;

public interface BodyService {

    Body getOne(Long id);
    List<Body> getAll();
    ItemCreateResponse createBody(BodyDto bodyDto);
    ItemCreateResponse updateBody(BodyDto updatedBodyDto, Body oldBody);
    ItemDeleteResponse deleteBody(Body body);
}
