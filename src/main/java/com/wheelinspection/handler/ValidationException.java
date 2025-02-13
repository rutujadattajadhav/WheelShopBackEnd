package com.wheelinspection.handler;

import com.wheelinspection.error.WheelInspectionError;

import java.util.List;

public class ValidationException extends Exception{

   private List<String> errorlist;

    public ValidationException(List<String> errorlist) {
        this.errorlist = errorlist;
    }

    public List<String> getErrorlist() {
        return errorlist;
    }
}
