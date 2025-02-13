package com.wheelinspection.responce;

import com.wheelinspection.error.WheelInspectionError;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResponce {
    Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
