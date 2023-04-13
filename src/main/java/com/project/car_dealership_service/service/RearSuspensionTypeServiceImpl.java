package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.RearSuspensionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RearSuspensionTypeServiceImpl implements RearSuspensionTypeService{
    @Override
    public List<RearSuspensionType> getAllRearSuspensionType() {
        return null;
    }

    @Override
    public RearSuspensionType getByIdRearSuspensionType(Long id) {
        return null;
    }

    @Override
    public void addRearSuspensionType(RearSuspensionType rearSuspensionType) {

    }

    @Override
    public void deleteRearSuspensionType(Long id) {

    }

    @Override
    public void patchRearSuspensionType(RearSuspensionType updatedRearSuspensionType, Long id) {

    }
}
