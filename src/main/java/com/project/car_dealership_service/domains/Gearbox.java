package com.project.car_dealership_service.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gearboxes")
public class Gearbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gearboxName;
    private String gearboxModel;
    private Integer stages;
    private String drive;

    @ManyToOne
    @JoinColumn(name = "gearbox_type_id", nullable = false)
    private GearboxType gearboxType;
}
