package com.project.car_dealership_service.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "attachments")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String linkFile;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "car_id", nullable = false)
    @JsonBackReference
    private Car car;
}
