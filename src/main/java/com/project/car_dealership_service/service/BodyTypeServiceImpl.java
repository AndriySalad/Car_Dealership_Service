package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.BodyTypeRepository;
import com.project.car_dealership_service.domains.BodyType;
import com.project.car_dealership_service.utils.ItemAlreadyExistsException;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodyTypeServiceImpl implements BodyTypeService{

    private final BodyTypeRepository bodyTypeRepository;

    @Override
    public BodyType getById(Long id) {
        return bodyTypeRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<BodyType> getAll() {
        return bodyTypeRepository.findAll();
    }

    @Override
    public ItemCreateResponse createBodyType(BodyType newBodyType) {
        if (bodyTypeRepository.findByBodyTypeName(newBodyType.getBodyTypeName())){
            throw new ItemAlreadyExistsException();
        }
        BodyType bodyType = BodyType.builder()
                .bodyTypeName(newBodyType.getBodyTypeName())
                .build();
        bodyTypeRepository.save(bodyType);
        return ItemCreateResponse.builder()
                .message("Тип кузова створено!")
                .item(bodyType.getBodyTypeName())
                .build();
    }

    @Override
    public ItemCreateResponse updateBodyType(BodyType updatedBodyType, BodyType oldBodyType) {
        if (bodyTypeRepository.findByBodyTypeName(updatedBodyType.getBodyTypeName())){
            throw new ItemAlreadyExistsException();
        }
        oldBodyType.setBodyTypeName(updatedBodyType.getBodyTypeName());
        bodyTypeRepository.save(oldBodyType);
        return ItemCreateResponse.builder()
                .message("Тип кузову обновлено!")
                .item(updatedBodyType.getBodyTypeName())
                .build();
    }

    @Override
    public ItemDeleteResponse deleteBodyType(BodyType bodyType) {
        bodyTypeRepository.delete(bodyType);
        return ItemDeleteResponse.builder()
                .message("Тип кузову видалено!")
                .object(bodyType)
                .build();
    }
}
