package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.Body;
import com.project.car_dealership_service.service.BodyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/body")
@AllArgsConstructor
public class BodyController {

    private final BodyService bodyService;

    @GetMapping
    public List<Body> getAll(){
        return bodyService.getAllBody();
    }

    @GetMapping("/{id}")
    public Body getById(@PathVariable Long id){
        return bodyService.getByIdBody(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addBody(@RequestBody Body body){
        bodyService.addBody(body);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBody(@PathVariable Long id){
        bodyService.deleteBody(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateBody(@PathVariable Long id, @RequestBody Body updatedBody){
        bodyService.patchBody(updatedBody, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<BodyErrorResponse> handleBodyException(BodyNotFoundException e){
        BodyErrorResponse response = new BodyErrorResponse(
                "Body with this id was not found.",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
