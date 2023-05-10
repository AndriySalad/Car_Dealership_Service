package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
