package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.BodyType;
import com.project.car_dealership_service.service.BodyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/body-types")
public class BodyTypeController {

    private final BodyTypeService bodyTypeService;

    @GetMapping
    public List<BodyType> getAll(){
        return bodyTypeService.getAll();
    }

    @GetMapping("/{id}")
    public BodyType getById(@PathVariable Long id){
        return bodyTypeService.getById(id);
    }
}
