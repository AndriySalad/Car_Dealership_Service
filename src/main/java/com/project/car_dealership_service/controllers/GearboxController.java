package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.service.GearBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gearbox")
public class GearboxController {

    private final GearBoxService gearBoxService;
}
