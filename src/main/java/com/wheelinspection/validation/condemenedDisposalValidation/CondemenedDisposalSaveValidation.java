package com.wheelinspection.validation.condemenedDisposalValidation;

import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.handler.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CondemenedDisposalSaveValidation {
    public void validate(CondemenedDisposal condemenedDisposal) throws ValidationException {
        List<String> errorList=new ArrayList<>();
        if(Objects.isNull(condemenedDisposal)){
            errorList.add("Object is null");
        }else{
            if(StringUtils.isEmpty(condemenedDisposal.getDate())){
                errorList.add("Date is null");
            }
            if(StringUtils.isEmpty(condemenedDisposal.getDepot())){
                errorList.add("Depot is null");
            }
            if(StringUtils.isEmpty(condemenedDisposal.getDescription())){
                errorList.add("Discription  is null");
            }
            if(StringUtils.isEmpty(condemenedDisposal.getDs8G27())){
                errorList.add("Ds8G27 is null");
            }
            if(StringUtils.isEmpty(condemenedDisposal.getMyUnknownColumn())){
                errorList.add("MyUnknownColumn is null");
            }
            if(StringUtils.isEmpty(condemenedDisposal.getPlNo())){
                errorList.add("PlNo is null");
            }
            if(StringUtils.isEmpty(condemenedDisposal.getQty())){
                errorList.add("Qty is null");
            }
            if(StringUtils.isEmpty(condemenedDisposal.getQtyInWeight())){
                errorList.add("QuantityInWeight is null");
            }
            if(StringUtils.isEmpty(condemenedDisposal.getSrNo())){
                errorList.add("SrNo is null");
            }
        }
        if(!errorList.isEmpty()){
            throw new ValidationException(errorList);
        }
    }
}
