package com.project.car_dealership_service.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String engineName;
    private Long engineCapacity;
    private String power;
    private Long numberOfCylinders;
    private String engineType;
    private String fuelType;
    @OneToMany(mappedBy = "engine", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Car> listBody;
}
