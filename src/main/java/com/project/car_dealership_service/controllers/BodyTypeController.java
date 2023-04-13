package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.BodyType;
import com.project.car_dealership_service.service.BodyTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/body-type")
@AllArgsConstructor
public class BodyTypeController {

    private final BodyTypeService bodyTypeService;

    @GetMapping
    public List<BodyType> getAll(){
        return bodyTypeService.getAllBodyType();
    }

    @GetMapping("/{id}")
    public BodyType getById(@PathVariable Long id){
        return bodyTypeService.getByIdBodyType(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addBodyType(@RequestBody BodyType bodyType){
        bodyTypeService.addBodyType(bodyType);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBodyType(@PathVariable Long id){
        bodyTypeService.deleteBodyType(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<BodyTypeErrorResponse> handleBodyTypeException(BodyTypeNotFoundException e){
        BodyTypeErrorResponse response = new BodyTypeErrorResponse(
                "Body type with this id wasn`t found.",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
