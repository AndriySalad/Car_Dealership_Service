package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.BodyRepository;
import com.project.car_dealership_service.domains.Body;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BodyServiceImpl implements BodyService{

    private final BodyRepository bodyRepository;
    @Override
    public List<Body> getAllBody() {
        return bodyRepository.findAll();
    }

    @Override
    public Body getByIdBody(Long id) {
        return bodyRepository.findById(id).orElseThrow(BodyNotFoundException::new);
    }

    @Override
    public void addBody(Body body) {
        bodyRepository.save(body);
    }

    @Override
    public void deleteBody(Long id) {
        Body body = bodyRepository.findById(id).orElseThrow(BodyNotFoundException::new);
        bodyRepository.delete(body);
    }

    @Override
    public void patchBody(Body newBody, Long id) {
        Body body = bodyRepository.findById(id).orElse(new Body());

        body.setBodyType(newBody.getBodyType());
        body.setLength(newBody.getLength());
        body.setHeight(newBody.getHeight());
        body.setDoorCount(newBody.getDoorCount());
        body.setWidth(newBody.getWidth());
        body.setClearance(newBody.getClearance());
        body.setSeatCount(newBody.getSeatCount());
        body.setTrunkVolume(newBody.getTrunkVolume());

        bodyRepository.save(body);
    }
}
