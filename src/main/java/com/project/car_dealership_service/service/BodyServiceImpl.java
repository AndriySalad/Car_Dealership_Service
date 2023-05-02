package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.BodyRepository;
import com.project.car_dealership_service.dao.BodyTypeRepository;
import com.project.car_dealership_service.domains.Body;
import com.project.car_dealership_service.dto.BodyDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodyServiceImpl implements BodyService{

    private final BodyRepository bodyRepository;
    private final BodyTypeRepository bodyTypeRepository;
    @Override
    public Body getOne(Long id) {
        return bodyRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<Body> getAll() {
        return bodyRepository.findAll();
    }

    @Override
    public ItemCreateResponse createBody(BodyDto bodyDto) {
        Body body = Body.builder()
                .bodyType(bodyTypeRepository.findBodyTypeByBodyTypeName(bodyDto.getBodyType()))
                .length(bodyDto.getLength())
                .width(bodyDto.getWidth())
                .height(bodyDto.getHeight())
                .clearance(bodyDto.getClearance())
                .seatCount(bodyDto.getSeatCount())
                .doorCount(bodyDto.getDoorCount())
                .trunkVolume(bodyDto.getTrunkVolume())
                .build();
        bodyRepository.save(body);
        return ItemCreateResponse.builder()
                .item(body)
                .message("Кузов створено!")
                .build();
    }

    @Override
    public ItemCreateResponse updateBody(BodyDto updatedBody, Body oldBody) {
        oldBody.setBodyType(bodyTypeRepository.findBodyTypeByBodyTypeName(updatedBody.getBodyType()));
        oldBody.setWidth(updatedBody.getWidth());
        oldBody.setHeight(updatedBody.getHeight());
        oldBody.setClearance(updatedBody.getClearance());
        oldBody.setLength(updatedBody.getLength());
        oldBody.setTrunkVolume(updatedBody.getTrunkVolume());
        oldBody.setSeatCount(updatedBody.getSeatCount());
        oldBody.setDoorCount(updatedBody.getDoorCount());
        bodyRepository.save(oldBody);
        return ItemCreateResponse.builder()
                .item(oldBody)
                .message("Кузов редаговано!")
                .build();
    }

    @Override
    public ItemDeleteResponse deleteBody(Body body) {
        bodyRepository.delete(body);
        return ItemDeleteResponse.builder()
                .message("Об'єкт кузова видалено!")
                .object(body)
                .build();
    }
}
