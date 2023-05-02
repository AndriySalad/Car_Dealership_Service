package com.project.car_dealership_service.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDeleteResponse {
    private String message;
    private Object object;
}
