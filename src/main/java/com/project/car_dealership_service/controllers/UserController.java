package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.domains.Order;
import com.project.car_dealership_service.domains.User;
import com.project.car_dealership_service.service.OrderService;
import com.project.car_dealership_service.service.UserService;
import com.project.car_dealership_service.utils.UserChangeInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final OrderService orderService;

    @GetMapping("/profile")
    public User profile(){
        return userService.getByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/profile/order")
    public List<Order> getUserOrders(){
        User user = userService.getByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return orderService.getAllByUser(user);
    }

    @PutMapping("/profile/save-settings")
    public User updateUser(@RequestBody UserChangeInfoRequest updatedUser){
        User user = userService.getByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return userService.updateUser(updatedUser, user);
    }
}
