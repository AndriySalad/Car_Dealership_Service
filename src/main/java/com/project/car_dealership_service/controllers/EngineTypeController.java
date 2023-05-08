package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.EngineType;
import com.project.car_dealership_service.service.EngineTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/engine-type")
public class EngineTypeController {

    private final EngineTypeService engineTypeService;

    @GetMapping
    public List<EngineType> getAll(){
        return engineTypeService.getAll();
    }

    @GetMapping("/{id}")
    public EngineType getById(@PathVariable Long id){
        return engineTypeService.findById(id);
    }
}
