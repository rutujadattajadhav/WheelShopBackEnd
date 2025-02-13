package com.wheelinspection.handler;

public class ServiceException extends Exception{
    private int code;
    public ServiceException(String message, int code) {
        super(message);
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
