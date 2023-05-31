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
@Table(name = "body_types")
public class BodyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bodyTypeName;

    @OneToMany(mappedBy = "bodyType", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Car> listBody;
}
