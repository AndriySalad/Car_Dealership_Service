package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.RearSuspensionType;

import java.util.List;

public interface RearSuspensionTypeService {
    List<RearSuspensionType> getAllRearSuspensionType();
    RearSuspensionType getByIdRearSuspensionType(Long id);
    void addRearSuspensionType(RearSuspensionType rearSuspensionType);

    void deleteRearSuspensionType(Long id);
    void patchRearSuspensionType(RearSuspensionType updatedRearSuspensionType, Long id);
}
