package com.wheelinspection.service;

import com.wheelinspection.entity.DemuBearingRejectionData;
import com.wheelinspection.entity.FinalInspectionOfWheel;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.FinalInspectionOfWheelRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FinalInspectionOfWheelService {
    @Autowired
    private FinalInspectionOfWheelRepository repository;

    public List<FinalInspectionOfWheel> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws ServiceException {
        if(repository.existsById(id)){
          Optional<FinalInspectionOfWheel> finalInspectionOfWheel = repository.findById(id);
          if(finalInspectionOfWheel.isPresent()){
              ApplicationResponce applicationResponce  =new ApplicationResponce();
              applicationResponce.setData(finalInspectionOfWheel);
              return applicationResponce;
          }
        }
        throw new ServiceException("record not found",65);
    }

    public ApplicationResponce createRecord(FinalInspectionOfWheel record) throws ServiceException {
        FinalInspectionOfWheel finalInspectionOfWheel  =repository.save(record);
        if(finalInspectionOfWheel!=null){
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData(finalInspectionOfWheel);
            return applicationResponce;
        }
        throw new ServiceException("not save successfully",23);
    }

    public ApplicationResponce updateRecord(Long id, FinalInspectionOfWheel updatedRecord) throws ServiceException {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            FinalInspectionOfWheel finalInspectionOfWheel  =repository.save(updatedRecord);
            if(finalInspectionOfWheel!=null){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData(finalInspectionOfWheel);
                return applicationResponce;
            }
        }
        throw new ServiceException("not update successfully",42);
    }

    public ApplicationResponce deleteRecord(Long id) throws ServiceException {
        if(repository.existsById(id)){
            repository.deleteById(id);
            ApplicationResponce applicationResponce=new ApplicationResponce();
            applicationResponce.setData("delete successfully");
            return applicationResponce;
        }
        throw new ServiceException("record not found",98);
    }

    public Page<FinalInspectionOfWheel> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
