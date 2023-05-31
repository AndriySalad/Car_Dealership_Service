package com.project.car_dealership_service.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.domains.Drive;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @OneToMany(mappedBy = "gearbox", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Car> listCar;
}
