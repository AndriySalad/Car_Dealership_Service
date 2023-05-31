package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Attachment;
import com.project.car_dealership_service.domains.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    List<Attachment> getAttachmentsByCar(Car car);
}
