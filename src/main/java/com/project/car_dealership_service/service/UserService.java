package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.RearSuspensionType;
import com.project.car_dealership_service.domains.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getByIdUser(Long id);
    void addUser(User user);

    void deleteUser(Long id);
    void patchUser(User updatedUser, Long id);
}
