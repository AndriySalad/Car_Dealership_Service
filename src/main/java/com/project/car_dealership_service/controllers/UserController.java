package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.User;
import com.project.car_dealership_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public User profile(){
        return userService.getByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }


}
