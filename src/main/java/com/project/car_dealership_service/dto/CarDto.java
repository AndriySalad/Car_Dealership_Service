package com.project.car_dealership_service.dto;

import com.project.car_dealership_service.domains.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.Date;
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
    private String yearOfCreation;
    private Long length;
    private Long width;
    private Long height;
    private Long clearance;
    private Long trunkVolume;
    private String carBrandName;
    private String maxSpeed;
    private String fuelUsage;
    private String bodyTypeName;
    private String gearboxName;
    private String gearboxModel;
    private Integer stages;
    private String drive;
    private String gearboxType;
    private String engineName;
    private Long engineCapacity;
    private String power;
    private Long numberOfCylinders;
    private String engineType;
    private String fuelType;
    private Long millage;
}
