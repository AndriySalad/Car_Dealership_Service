package com.project.car_dealership_service.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoResponse {
    private Long countCars;
    private Long countOrders;
    private Long countUsers;
}
