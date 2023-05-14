package com.project.car_dealership_service.controllers;

import com.project.car_dealership_service.utils.ItemErrorResponse;
import com.project.car_dealership_service.utils.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer could not be found!")
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseBody
    void handleEntityNotFoundEx(ItemNotFoundException ex) {
    }
}
