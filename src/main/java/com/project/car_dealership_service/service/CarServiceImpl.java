package com.project.car_dealership_service.service;

import com.project.car_dealership_service.dao.AttachmentRepository;
import com.project.car_dealership_service.dao.CarRepository;
import com.project.car_dealership_service.domains.Attachment;
import com.project.car_dealership_service.domains.Car;
import com.project.car_dealership_service.dto.CarDto;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final  FileUpload fileUpload;
    private final AttachmentRepository attachmentRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public ItemCreateResponse createCar(CarDto carDto) {
        List<Attachment> attachmentList = null;

        carDto.getAttachments().stream().forEach(item -> {
            try {
                attachmentList.add(Attachment.builder()
                                .linkFile(fileUpload.uploadFile(item))
                                .build());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Car newCar = Car.builder()
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
                .carBrand(carDto.getCarBrand())
                .gearbox(carDto.getGearbox())
                .engine(carDto.getEngine())
                .attachments(attachmentList)
                .bodyType(carDto.getBodyType())
                .build();
        carRepository.save(newCar);
        for (Attachment item: attachmentList) {
            item.setCar(newCar);
            attachmentRepository.save(item);
        }
        return ItemCreateResponse.builder()
                .item(newCar)
                .message("Машину створено!")
                .build();
    }

    @Override
    public ItemCreateResponse updateCar(CarDto updatedCarDto, Car oldCar) {
        oldCar.setCarBrand(updatedCarDto.getCarBrand());
        oldCar.setDescription(updatedCarDto.getDescription());
        oldCar.setClearance(updatedCarDto.getClearance());
        oldCar.setEngine(updatedCarDto.getEngine());
        oldCar.setGearbox(updatedCarDto.getGearbox());
        oldCar.setHeight(updatedCarDto.getHeight());
        oldCar.setBodyType(updatedCarDto.getBodyType());
        oldCar.setLength(updatedCarDto.getLength());
        oldCar.setDoorCount(updatedCarDto.getDoorCount());
        oldCar.setWidth(updatedCarDto.getWidth());
        oldCar.setTrunkVolume(updatedCarDto.getTrunkVolume());
        oldCar.setPrice(updatedCarDto.getPrice());
        oldCar.setFuelUsage(updatedCarDto.getFuelUsage());
        oldCar.setMaxSpeed(updatedCarDto.getMaxSpeed());
        oldCar.setModel(updatedCarDto.getModel());
        carRepository.save(oldCar);
        return ItemCreateResponse.builder()
                .item(oldCar)
                .message("Машину обновлено!")
                .build();
    }

    @Override
    public ItemDeleteResponse deleteCar(Car car) {
        carRepository.delete(car);
        return ItemDeleteResponse.builder()
                .message("Машину видалено!")
                .object(car)
                .build();
    }
}
