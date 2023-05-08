package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.EngineTypeRepository;
import com.project.car_dealership_service.domains.EngineType;
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
public class EngineTypeImpl implements EngineTypeService {

    private final EngineTypeRepository engineTypeRepository;

    @Override
    public List<EngineType> getAll() {
        return engineTypeRepository.findAll();
    }

    @Override
    public EngineType findById(Long id) {
        return engineTypeRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public ItemCreateResponse createEngineType(EngineType engineType) {
        Optional<EngineType> check = engineTypeRepository.findByEngineType(engineType.getEngineType());
        if(check.isPresent()){
            throw new ItemAlreadyExistsException();
        }
        EngineType newEngineType = EngineType.builder()
                .engineType(engineType.getEngineType())
                .build();
        engineTypeRepository.save(newEngineType);
        return ItemCreateResponse.builder()
                .item(newEngineType)
                .message("Тип двигуна створено!")
                .build();
    }

    @Override
    public ItemCreateResponse updateEngineType(EngineType updatedEngineType, EngineType oldEngineType) {
        Optional<EngineType> check = engineTypeRepository.findByEngineType(updatedEngineType.getEngineType());
        if(check.isPresent()){
            throw new ItemAlreadyExistsException();
        }
        oldEngineType.setEngineType(updatedEngineType.getEngineType());
        engineTypeRepository.save(oldEngineType);
        return ItemCreateResponse.builder()
                .item(oldEngineType)
                .message("Тип двигуна створено!")
                .build();
    }

    @Override
    public ItemDeleteResponse deleteEngineType(EngineType engineType) {
        engineTypeRepository.delete(engineType);
        return ItemDeleteResponse.builder()
                .object(engineType)
                .message("Тип двигуна видалено!")
                .build();
    }
}
