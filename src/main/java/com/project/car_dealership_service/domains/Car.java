package com.project.car_dealership_service.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

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
    private String yearOfCreation;
    private BigInteger price;
    @Enumerated(EnumType.STRING)
    private AvailableStatus status;
    private Integer doorCount;
    private Integer seatCount;
    private Long length;
    private Long width;
    private Long height;
    private Long clearance;
    private Long trunkVolume;
    private String maxSpeed;
    private String fuelUsage;
    private Long millage;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    @JsonManagedReference
    private BodyType bodyType;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "engine_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Engine engine;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "gearbox_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Gearbox gearbox;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "car_brand_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CarBrand carBrand;
    @OneToOne(mappedBy = "car", cascade = CascadeType.REFRESH)
    @JsonBackReference
    private Order order;
    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Attachment> attachments;
}
