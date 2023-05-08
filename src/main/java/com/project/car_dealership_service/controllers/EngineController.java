package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.Engine;
import com.project.car_dealership_service.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/engine")
public class EngineController {

    private final EngineService engineService;

    @GetMapping
    public List<Engine> getAll(){
        return engineService.getAll();
    }

    @GetMapping("/{id}")
    public Engine findById(@PathVariable Long id){
        return engineService.findById(id);
    }
}
