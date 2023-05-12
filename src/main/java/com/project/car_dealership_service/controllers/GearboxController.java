package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.Gearbox;
import com.project.car_dealership_service.service.GearBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gearbox")
public class GearboxController {

    private final GearBoxService gearBoxService;

    @GetMapping
    List<Gearbox> getAll(){
        return gearBoxService.getAll();
    }
}
