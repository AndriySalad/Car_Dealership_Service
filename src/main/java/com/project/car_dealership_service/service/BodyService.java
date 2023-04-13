package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.Body;


import java.util.List;

public interface BodyService {
    List<Body> getAllBody();
    Body getByIdBody(Long id);
    void addBody(Body bodyType);

    void deleteBody(Long id);
    void patchBody(Body newBody, Long id);
}
