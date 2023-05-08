package com.project.car_dealership_service.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45)
    private String model;
    @Column(length = 2500)
    private String description;
    private Date dateOfCreation;
    private BigInteger price;
    @Enumerated(EnumType.STRING)
    private AvailableStatus status;
    private String frontSuspensionType;
    private String rearSuspensionType;
    private Integer doorCount;
    private Integer seatCount;
    private Long length;
    private Long width;
    private Long height;
    private Long clearance;
    private Long trunkVolume;
    private String rearBrakingSystemName;
    private String frontBrakingSystemName;

    @ManyToOne
    @JoinColumn(name = "body_type_id", nullable = false)
    private BodyType bodyType;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "engine_id", nullable = false)
    private Engine engine;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "gearbox_id", nullable = false)
    private Gearbox gearbox;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "car_brand_id", nullable = false)
    private CarBrand carBrand;
    @OneToOne(mappedBy = "car", cascade = CascadeType.REFRESH)
    private Order order;
    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
    private List<Attachment> attachments;
}
