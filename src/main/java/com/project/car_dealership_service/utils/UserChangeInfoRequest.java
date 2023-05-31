package com.project.car_dealership_service.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserChangeInfoRequest {
    private String firstName;
    private String lastName;
    private String name;
    private String email;
    private String phoneNumber;
}
