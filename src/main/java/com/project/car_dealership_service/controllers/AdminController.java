package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.dao.BrakingSystemRepository;
import com.project.car_dealership_service.domains.Body;
import com.project.car_dealership_service.domains.BodyType;
import com.project.car_dealership_service.domains.BrakingSystem;
import com.project.car_dealership_service.domains.User;
import com.project.car_dealership_service.dto.BodyDto;
import com.project.car_dealership_service.service.BodyService;
import com.project.car_dealership_service.service.BodyTypeService;
import com.project.car_dealership_service.service.BrakingSystemService;
import com.project.car_dealership_service.service.UserService;
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
    private final BodyService bodyService;
    private final BrakingSystemService brakingSystemService;

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

    @PostMapping("/body/new")
    public ResponseEntity<ItemCreateResponse> newBody(@RequestBody BodyDto newBody) throws Exception {
        return ResponseEntity.ok(bodyService.createBody(newBody));
    }

    @PutMapping("/body/update/{id}")
    public ResponseEntity<ItemCreateResponse> updateBody(@RequestBody BodyDto updatedBody, @PathVariable Long id) throws Exception {
        Body body = bodyService.getOne(id);
        return ResponseEntity.ok(bodyService.updateBody(updatedBody, body));
    }

    @DeleteMapping("/body/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteBody(@PathVariable Long id){
        Body body = bodyService.getOne(id);
        return ResponseEntity.ok(bodyService.deleteBody(body));
    }

    @PostMapping("/braking-system/new")
    public ResponseEntity<ItemCreateResponse> newBrakingSystem(@RequestBody BrakingSystem brakingSystem){
        return ResponseEntity.ok(brakingSystemService.createBrakingSystem(brakingSystem));
    }

    @PutMapping("/braking-system/update/{id}")
    public ResponseEntity<ItemCreateResponse> updateBrakingSystem(@RequestBody BrakingSystem updatedBrakingSystem, @PathVariable Long id){
        BrakingSystem brakingSystem = brakingSystemService.getOne(id);
        return ResponseEntity.ok(brakingSystemService.updateBrakingSystem(updatedBrakingSystem, brakingSystem));
    }

    @DeleteMapping("/braking-system/delete/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteBrakingSystem(@PathVariable Long id){
        BrakingSystem brakingSystem = brakingSystemService.getOne(id);
        return ResponseEntity.ok(brakingSystemService.deleteBrakingSystem(brakingSystem));
    }
}
