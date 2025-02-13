package com.wheelinspection.validation.breakDownHistoryValidation;

import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.error.WheelInspectionError;
import com.wheelinspection.handler.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class BreakDownHistorySaveValidation {
    public void validate(BreakdownHistory breakdownHistory) throws ValidationException {
        List<String> errorList=new ArrayList<>();
        if(Objects.isNull(breakdownHistory)){
            errorList.add("Object is null");
        }else{
            if(StringUtils.isEmpty(breakdownHistory.getFromDate())){
                errorList.add("Form date is null");
            }
            if(StringUtils.isEmpty(breakdownHistory.getIssue())){
                errorList.add("Issue is null");
            }
            if(StringUtils.isEmpty(breakdownHistory.getNoOfDays())){
                errorList.add("No of days is null");
            }
            if(StringUtils.isEmpty(breakdownHistory.getPlantName())){
                errorList.add("Plant name is null");
            }
            if(StringUtils.isEmpty(breakdownHistory.getSerialNumber())){
                errorList.add("serial number is null");
            }
            if(StringUtils.isEmpty(breakdownHistory.getToDate())){
                errorList.add("To date is null");
            }
        }
        if(!errorList.isEmpty()){
            throw new ValidationException(Collections.singletonList(errorList.toString()));
        }
    }
}
