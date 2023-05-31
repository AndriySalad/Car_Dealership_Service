package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.*;

import com.project.car_dealership_service.domains.*;
import com.project.car_dealership_service.dto.CarDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final  FileUpload fileUpload;
    private final AttachmentRepository attachmentRepository;
    private final GearboxRepository gearboxRepository;
    private final EngineRepository engineRepository;
    private final BodyTypeRepository bodyTypeRepository;
    private final CarBrandRepository carBrandRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public Car createCar(CarDto carDto, List<MultipartFile> files) {
        List<Attachment> attachmentList = new ArrayList<>();

        files.stream().forEach(item -> {
            try {
                attachmentList.add(Attachment.builder()
                                .linkFile(fileUpload.uploadFile(item))
                                .build());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Optional<CarBrand> carBrandCheck = carBrandRepository.findByCarBrandName(carDto.getCarBrandName());
        CarBrand carBrand = carBrandCheck.orElse(CarBrand.builder().carBrandName(carDto.getCarBrandName()).build());

        carBrandRepository.save(carBrand);

        Engine engine = Engine.builder()
                .numberOfCylinders(carDto.getNumberOfCylinders())
                .engineCapacity(carDto.getEngineCapacity())
                .power(carDto.getPower())
                .engineName(carDto.getEngineName())
                .engineType(carDto.getGearboxType())
                .fuelType(carDto.getFuelType())
                .build();
        engineRepository.save(engine);

        Gearbox gearbox = Gearbox.builder()
                .stages(carDto.getStages())
                .gearboxType(carDto.getGearboxType())
                .drive(Drive.valueOf(carDto.getDrive()))
                .gearboxModel(carDto.getGearboxModel())
                .gearboxName(carDto.getGearboxName())
                .build();

        gearboxRepository.save(gearbox);

        BodyType bodyType = bodyTypeRepository.findByBodyTypeName(carDto.getBodyTypeName()).orElse(BodyType.builder()
                        .bodyTypeName(carDto.getBodyTypeName())
                        .build());

        bodyTypeRepository.save(bodyType);



        Car newCar = Car.builder()
                .yearOfCreation(carDto.getYearOfCreation())
                .model(carDto.getModel())
                .description(carDto.getDescription())
                .doorCount(carDto.getDoorCount())
                .seatCount(carDto.getSeatCount())
                .fuelUsage(carDto.getFuelUsage())
                .height(carDto.getHeight())
                .clearance(carDto.getClearance())
                .length(carDto.getLength())
                .maxSpeed(carDto.getMaxSpeed())
                .price(carDto.getPrice())
                .width(carDto.getWidth())
                .trunkVolume(carDto.getTrunkVolume())
                .carBrand(carBrand)
                .gearbox(gearbox)
                .engine(engine)
                .bodyType(bodyType)
                .status(AvailableStatus.AVAILABLE)
                .millage(carDto.getMillage())
                .build();
        carRepository.save(newCar);
        for (Attachment item: attachmentList) {
            item.setCar(newCar);
            attachmentRepository.save(item);
        }
        newCar.setAttachments(attachmentRepository.getAttachmentsByCar(newCar));
        carRepository.save(newCar);
        return newCar;
    }


    @Override
    public ItemDeleteResponse deleteCar(Car car) {
        carRepository.delete(car);
        return ItemDeleteResponse.builder()
                .message("Машину видалено!")
                .build();
    }
}
