package com.wheelinspection.validation.axleRejectionValidation;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.handler.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SaveValidation {
    public void validate(AxleRejection axleRejection) throws ValidationException {
        List<String> errorList=new ArrayList<>();
        if(Objects.isNull(axleRejection)){
            errorList.add("Object is null");
        }else{
            if(StringUtils.isEmpty(axleRejection.getAxleNo())){
                errorList.add("Axle no is null");
            }
            if(StringUtils.isEmpty(axleRejection.getYearOfMfg())){
                errorList.add("Year of MFG is null");
            }
            if(StringUtils.isEmpty(axleRejection.getReasonOfRejectionAxle())){
                errorList.add("Reason of Rejection is null");
            }
        }
        if(!errorList.isEmpty()){
            throw new ValidationException(errorList);
        }
    }
}
