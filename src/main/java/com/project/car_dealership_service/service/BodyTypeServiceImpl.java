package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.BodyTypeRepository;
import com.project.car_dealership_service.domains.BodyType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BodyTypeServiceImpl implements BodyTypeService{

    private final BodyTypeRepository bodyTypeRepository;

    @Override
    public List<BodyType> getAllBodyType() {
        return bodyTypeRepository.findAll();
    }

    @Override
    public BodyType getByIdBodyType(Long id) {
        return bodyTypeRepository.findById(id).orElseThrow(BodyTypeNotFoundException::new);
    }

    @Override
    public void addBodyType(BodyType bodyType) {
        bodyTypeRepository.save(bodyType);
    }

    @Override
    public void deleteBodyType(Long id) {
        BodyType bodyType = bodyTypeRepository.findById(id).orElseThrow(BodyTypeNotFoundException::new);
        bodyTypeRepository.delete(bodyType);
    }
}
