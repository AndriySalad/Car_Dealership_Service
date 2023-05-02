package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.BrakingSystemRepository;
import com.project.car_dealership_service.domains.BrakingSystem;
import com.project.car_dealership_service.utils.ItemAlreadyExistsException;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrakingSystemServiceImpl implements BrakingSystemService {

    private final BrakingSystemRepository brakingSystemRepository;

    @Override
    public List<BrakingSystem> getAll() {
        return brakingSystemRepository.findAll();
    }

    @Override
    public BrakingSystem getOne(Long id) {
        return brakingSystemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public ItemCreateResponse createBrakingSystem(BrakingSystem brakingSystem) {
        if (brakingSystemRepository.findByBrakingSystemName(brakingSystem.getBrakingSystemName())){
            throw new ItemAlreadyExistsException();
        }
        BrakingSystem newBrakingSystem = BrakingSystem.builder()
                .brakingSystemName(brakingSystem.getBrakingSystemName())
                .build();
        brakingSystemRepository.save(newBrakingSystem);
        return ItemCreateResponse.builder()
                .item(newBrakingSystem)
                .message("Гальмівну систему створено!")
                .build();
    }

    @Override
    public ItemCreateResponse updateBrakingSystem(BrakingSystem updatedBrakingSystem, BrakingSystem oldBrakingSystem) {
        if (brakingSystemRepository.findByBrakingSystemName(updatedBrakingSystem.getBrakingSystemName())){
            throw new ItemAlreadyExistsException();
        }
        oldBrakingSystem.setBrakingSystemName(updatedBrakingSystem.getBrakingSystemName());
        return ItemCreateResponse.builder()
                .item(oldBrakingSystem)
                .message("Гальмівну систему оновлено!")
                .build();
    }

    @Override
    public ItemDeleteResponse deleteBrakingSystem(BrakingSystem brakingSystem) {
        return ItemDeleteResponse.builder()
                .object(brakingSystem)
                .message("Гальмівну систему видалено!")
                .build();
    }
}
