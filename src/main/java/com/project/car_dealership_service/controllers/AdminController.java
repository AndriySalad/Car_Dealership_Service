package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.BodyType;
import com.project.car_dealership_service.domains.User;
import com.project.car_dealership_service.service.BodyTypeService;
import com.project.car_dealership_service.service.UserService;
import com.project.car_dealership_service.utils.AuthenticationResponse;
import com.project.car_dealership_service.utils.ItemCreateResponse;
import com.project.car_dealership_service.utils.ItemDeleteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final BodyTypeService bodyTypeService;

    @GetMapping("/users")
    public List<User> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/body-type/new")
    public ResponseEntity<ItemCreateResponse> newBodyType(@RequestBody BodyType bodyType){
        return ResponseEntity.ok(bodyTypeService.createBodyType(bodyType));
    }

    @PutMapping("/body-type/update/{id}")
    public ResponseEntity<ItemCreateResponse> updateBodyType(@RequestBody BodyType updatedBodyType, @PathVariable Long id){
        BodyType bodyType = bodyTypeService.getById(id);
        return ResponseEntity.ok(bodyTypeService.updateBodyType(updatedBodyType, bodyType));
    }

    @DeleteMapping("/body-type/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteBodyType(@PathVariable Long id){
        BodyType bodyType = bodyTypeService.getById(id);
        return ResponseEntity.ok(bodyTypeService.deleteBodyType(bodyType));
    }
}
