package com.project.car_dealership_service.dto;

import com.project.car_dealership_service.domains.Drive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GearboxDto {
    private String gearboxName;
    private String gearboxModel;
    private Integer stages;
    private Drive drive;
    private String gearboxType;
}
