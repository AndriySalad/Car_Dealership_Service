package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.BrakingSystemRepository;
import com.project.car_dealership_service.domains.BrakingSystem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrakingSystemServiceImpl implements BrakingSystemService{

    private final BrakingSystemRepository brakingSystemRepository;

    @Override
    public List<BrakingSystem> getAllBrakingSystem() {
        return brakingSystemRepository.findAll();
    }

    @Override
    public BrakingSystem getByIdBrakingSystem(Long id) {
        return brakingSystemRepository.findById(id).orElseThrow(BrakingSystemNotFoundException::new);
    }

    @Override
    public void addBrakingSystem(BrakingSystem brakingSystem) {
        brakingSystemRepository.save(brakingSystem);
    }

    @Override
    public void deleteBrakingSystem(Long id) {
        BrakingSystem brakingSystem = brakingSystemRepository.findById(id).orElseThrow(BrakingSystemNotFoundException::new);
        brakingSystemRepository.delete(brakingSystem);
    }

    @Override
    public void patchBrakingSystem(BrakingSystem updatedBrakingSystem, Long id) {
        BrakingSystem brakingSystem = brakingSystemRepository.findById(id).orElse(new BrakingSystem());
        brakingSystem.setBrakingSystemName(updatedBrakingSystem.getBrakingSystemName());
    }
}
