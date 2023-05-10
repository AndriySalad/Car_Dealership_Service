package com.project.car_dealership_service.dto;

import com.project.car_dealership_service.domains.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
    private String model;
    private String description;
    private BigInteger price;
    private Integer doorCount;
    private Integer seatCount;
    private Long length;
    private Long width;
    private Long height;
    private Long clearance;
    private Long trunkVolume;
    private BodyType bodyType;
    private Engine engine;
    private Gearbox gearbox;
    private CarBrand carBrand;
    private List<MultipartFile> attachments;
    private String maxSpeed;
    private String fuelUsage;
}
