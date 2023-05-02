package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.Body;
import com.project.car_dealership_service.domains.BodyType;
import com.project.car_dealership_service.service.BodyService;
import com.project.car_dealership_service.service.BodyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/body")
public class BodyController {

    private final BodyService bodyService;

    @GetMapping
    public List<Body> getAll(){
        return bodyService.getAll();
    }

    @GetMapping("/{id}")
    public Body getById(@PathVariable Long id){
        return bodyService.getOne(id);
    }
}
