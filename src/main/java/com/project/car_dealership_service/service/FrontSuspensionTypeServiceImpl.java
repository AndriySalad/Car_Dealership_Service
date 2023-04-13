package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.FrontSuspensionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FrontSuspensionTypeServiceImpl implements FrontSuspensionTypeService{
    @Override
    public List<FrontSuspensionType> getAllFrontSuspensionType() {
        return null;
    }

    @Override
    public FrontSuspensionType getByIdFrontSuspensionType(Long id) {
        return null;
    }

    @Override
    public void addFrontSuspensionType(FrontSuspensionType FrontSuspensionType) {

    }

    @Override
    public void deleteFrontSuspensionType(Long id) {

    }

    @Override
    public void patchFrontSuspensionType(FrontSuspensionType updatedFrontSuspensionType, Long id) {

    }
}
