package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.GearboxRepository;
import com.project.car_dealership_service.domains.Drive;
import com.project.car_dealership_service.domains.Gearbox;
import com.project.car_dealership_service.dto.GearboxDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GearboxServiceImpl implements  GearBoxService{

    private final GearboxRepository gearboxRepository;

    @Override
    public List<Gearbox> getAll() {
        return gearboxRepository.findAll();
    }

    @Override
    public Gearbox getById(Long id) {
        return gearboxRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public ItemCreateResponse createGearbox(GearboxDto gearboxDto) {

        Gearbox gearbox = Gearbox.builder()
                .gearboxName(gearboxDto.getGearboxName())
                .gearboxType(gearboxDto.getGearboxType())
                .gearboxModel(gearboxDto.getGearboxModel())
                .drive(gearboxDto.getDrive())
                .stages(gearboxDto.getStages())
                .build();
        gearboxRepository.save(gearbox);
        return ItemCreateResponse.builder()
                .message("Коробку передач створено!")
                .item(gearbox)
                .build();
    }

    @Override
    public ItemCreateResponse updateGearbox(GearboxDto updatedGearbox, Gearbox oldGearbox) {
        oldGearbox.setGearboxName(updatedGearbox.getGearboxName());
        oldGearbox.setGearboxModel(updatedGearbox.getGearboxModel());
        oldGearbox.setGearboxType(updatedGearbox.getGearboxType());
        oldGearbox.setStages(updatedGearbox.getStages());
        oldGearbox.setDrive(updatedGearbox.getDrive());

        return ItemCreateResponse.builder()
                .message("Коробку передач обдновлено!")
                .item(oldGearbox)
                .build();
    }

    @Override
    public ItemDeleteResponse deleteGearbox(Gearbox gearbox) {
        gearboxRepository.delete(gearbox);
        return ItemDeleteResponse.builder()
                .message("Коробку передач видалено!")
                .build();
    }
}
