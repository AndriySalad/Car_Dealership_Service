package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.BodyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyTypeRepository extends JpaRepository<BodyType, Long> {
    boolean findByBodyTypeName(String bodyTypeName);
    BodyType findBodyTypeByBodyTypeName(String bodyTypeName);
}
