package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
