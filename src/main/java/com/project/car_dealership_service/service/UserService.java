package com.project.car_dealership_service.service;


import com.project.car_dealership_service.domains.User;
import com.project.car_dealership_service.utils.AuthenticationRequest;
import com.project.car_dealership_service.utils.AuthenticationResponse;
import com.project.car_dealership_service.utils.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface UserService {

    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    void saveUserToken(User user, String jwtToken);
    void revokeAllUserTokens(User user);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
