package com.wheelinspection.validation.bearingRejectionValidation;

import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.error.WheelInspectionError;
import com.wheelinspection.handler.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
public class BearingRejectionSaveValidation {

    public void validate(BearingRejectionData bearingRejectionData) throws ValidationException {
        List<String> errorList=new ArrayList<>();
        if(Objects.isNull(bearingRejectionData)){
            errorList.add("Object is null");
        }else{
            if(StringUtils.isEmpty(bearingRejectionData.getBearingType())){
                errorList.add("Bearing type is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getDate())){
                errorList.add("Date is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getCount())){
                errorList.add("count is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getMake())){
                errorList.add("Make is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getLifeInMonth())){
                errorList.add("Life in month is null is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getLifeInYear())){
                errorList.add("Life in year is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getMfgNo())){
                errorList.add("MFG No is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getMonth())){
                errorList.add("Month is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getReasonForRejection())){
                errorList.add("Reason of rejection is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getRejectionPercentage())){
                errorList.add("RejectionPercentage is null");
            }
            if(StringUtils.isEmpty(bearingRejectionData.getTotalInspected())){
                errorList.add("Total Inspected is null");
            }
        }
        if(!errorList.isEmpty()){
            throw new ValidationException(errorList);
        }
    }
}
