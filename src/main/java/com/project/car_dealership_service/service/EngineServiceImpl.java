package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.EngineRepository;
import com.project.car_dealership_service.dao.FuelTypeRepository;
import com.project.car_dealership_service.domains.Engine;
import com.project.car_dealership_service.dto.EngineDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService{

    private final EngineRepository engineRepository;
    private final FuelTypeRepository fuelTypeRepository;

    @Override
    public List<Engine> getAll() {
        return engineRepository.findAll();
    }

    @Override
    public Engine findById(Long id) {
        return engineRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public ItemCreateResponse createEngine(EngineDto engineDto) {
        Engine engine = Engine.builder()
                .engineCapacity(engineDto.getEngineCapacity())
                .engineName(engineDto.getEngineName())
                .power(engineDto.getPower())
                .fuelType(fuelTypeRepository.findByFuelTypeName(engineDto.getFuelType()).orElseThrow(ItemNotFoundException::new))
                .engineType(engineDto.getEngineType())
                .numberOfCylinders(engineDto.getNumberOfCylinders())
                .build();
        engineRepository.save(engine);
        return ItemCreateResponse.builder()
                .message("Двигун створено!")
                .item(engine)
                .build();
    }

    @Override
    public ItemCreateResponse updateEngine(EngineDto updatedEngine, Engine oldEngine) {

        oldEngine.setEngineCapacity(updatedEngine.getEngineCapacity());
        oldEngine.setEngineType(updatedEngine.getEngineType());
        oldEngine.setEngineName(updatedEngine.getEngineName());
        oldEngine.setPower(updatedEngine.getPower());
        oldEngine.setFuelType(fuelTypeRepository.findByFuelTypeName(updatedEngine.getFuelType()).orElseThrow(ItemNotFoundException::new));
        oldEngine.setNumberOfCylinders(updatedEngine.getNumberOfCylinders());

        engineRepository.save(oldEngine);
        return ItemCreateResponse.builder()
                .message("Двигун обновлено!")
                .item(oldEngine)
                .build();
    }

    @Override
    public ItemDeleteResponse deleteEngine(Engine engine) {
        engineRepository.delete(engine);
        return ItemDeleteResponse.builder()
                .message("Двигун видалено!")
                .object(engine)
                .build();
    }
}
