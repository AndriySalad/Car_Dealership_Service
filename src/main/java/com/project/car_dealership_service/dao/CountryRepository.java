package com.project.car_dealership_service.dao;

import com.project.car_dealership_service.domains.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
