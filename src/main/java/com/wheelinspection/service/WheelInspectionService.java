package com.wheelinspection.service;

import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.model.WheelInspection;
import com.wheelinspection.repository.WheelInspectionRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WheelInspectionService {

    private final WheelInspectionRepository repository;

    public WheelInspectionService(WheelInspectionRepository repository) {
        this.repository = repository;
    }

    public List<WheelInspection> getAllInspections() {
        return repository.findAll();
    }

    public ApplicationResponce getInspectionById(Long id) throws ServiceException {
        if(repository.existsById(id)){
            Optional<WheelInspection> wheelInspection =repository.findById(id);
            if(wheelInspection.isPresent()){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData(wheelInspection);
                return applicationResponce;
            }
        }
        throw new ServiceException("Inspection not found",404);
    }

    public ApplicationResponce addInspection(WheelInspection inspection) throws ServiceException {
        WheelInspection wheelInspection  = repository.save(inspection);
        if(wheelInspection!=null){
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("Save Inspection successfully");
            return applicationResponce;
        }
        throw new ServiceException("not save successfully",500);
    }

}
