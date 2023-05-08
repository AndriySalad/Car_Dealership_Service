package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.FuelTypeRepository;
import com.project.car_dealership_service.domains.FuelType;
import com.project.car_dealership_service.utils.ItemAlreadyExistsException;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuelTypeServiceImpl implements FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;

    @Override
    public List<FuelType> getAll() {
        return fuelTypeRepository.findAll();
    }

    @Override
    public FuelType findById(Long id) {
        return fuelTypeRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public ItemCreateResponse createFuelType(FuelType newFuelType) {
        Optional<FuelType> fuelType = fuelTypeRepository.findByFuelTypeName(newFuelType.getFuelTypeName());
        if (fuelType.isPresent()){
            throw new ItemAlreadyExistsException();
        }
        FuelType fuelType1 = FuelType.builder()
                .fuelTypeName(newFuelType.getFuelTypeName())
                .build();
        fuelTypeRepository.save(fuelType1);
        return ItemCreateResponse.builder()
                .item(fuelType1)
                .message("Тип пального створено!")
                .build();
    }

    @Override
    public ItemDeleteResponse deleteFuelType(FuelType fuelType) {
        fuelTypeRepository.delete(fuelType);
        return ItemDeleteResponse.builder()
                .object(fuelType)
                .message("Тип пального видалено!")
                .build();
    }
}
