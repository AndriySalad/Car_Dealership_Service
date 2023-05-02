package com.project.car_dealership_service.dto;

import com.project.car_dealership_service.domains.BodyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BodyDto {
    private String bodyType;
    private Integer doorCount;
    private Integer seatCount;
    private Long length;
    private Long width;
    private Long height;
    private Long clearance;
    private Long trunkVolume;
}
