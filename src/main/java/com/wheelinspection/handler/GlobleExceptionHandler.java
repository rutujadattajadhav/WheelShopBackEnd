package com.wheelinspection.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;


import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public UserErrorResponse handleServiceException(ServiceException ex) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        //response.setPath(exchange.getRequest().getPath().toString());
        response.setStatus(ex.getCode());
        response.setError("Service Exception");
        response.setMessage(ex.getMessage());
        return new UserErrorResponse(response);
    }

    @ExceptionHandler(ValidationException.class)
    public UserErrorResponse handleValidationException(ValidationException ex) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        //response.setPath(exchange.getRequest().getPath().toString());
        response.setStatus(ex.getErrorlist().size());
        response.setError("Validation Error");
        response.setMessage("Invalid data provided");
        response.setErrors(ex.getErrorlist());
        return new UserErrorResponse(response);
    }

}
