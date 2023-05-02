package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.BrakingSystem;
import com.project.car_dealership_service.service.BrakingSystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/braking-system")
public class BrakingSystemController {

    private final BrakingSystemService brakingSystemService;

    @GetMapping
    public List<BrakingSystem> getAll(){
        return brakingSystemService.getAll();
    }

    @GetMapping("/{id}")
    public BrakingSystem getOne(@PathVariable Long id){
        return brakingSystemService.getOne(id);
    }
}
