package com.project.car_dealership_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EngineDto {
    private String engineName;
    private Long engineCapacity;
    private String power;
    private Long numberOfCylinders;
    private String fuelType;
    private String engineType;
}
