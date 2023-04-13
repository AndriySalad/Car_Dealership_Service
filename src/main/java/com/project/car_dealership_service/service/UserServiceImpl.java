package com.project.car_dealership_service.service;

import com.project.car_dealership_service.domains.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User getByIdUser(Long id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void patchUser(User updatedUser, Long id) {

    }
}
