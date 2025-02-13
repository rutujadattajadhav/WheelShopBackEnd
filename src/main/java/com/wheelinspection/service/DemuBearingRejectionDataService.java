package com.wheelinspection.service;

import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.entity.DemuBearingRejectionData;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.DemuBearingRejectionDataRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DemuBearingRejectionDataService {
    @Autowired
    private DemuBearingRejectionDataRepository repository;

    public List<DemuBearingRejectionData> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws ServiceException {
        if (repository.existsById(id)) {
            Optional<DemuBearingRejectionData> demuBearingRejectionData = repository.findById(id);
            if (demuBearingRejectionData.isPresent()) {
                ApplicationResponce applicationResponce = new ApplicationResponce();
                applicationResponce.setData(demuBearingRejectionData);
                return applicationResponce;
            }

    }
        throw new ServiceException("record not found",23);
    }

    public ApplicationResponce createRecord(DemuBearingRejectionData record) throws ServiceException {
        DemuBearingRejectionData demuBearingRejectionData=  repository.save(record);
        if(demuBearingRejectionData!=null){
            ApplicationResponce applicationResponce  =new ApplicationResponce();
            applicationResponce.setData(demuBearingRejectionData);
            return applicationResponce;
        }else{
            throw new ServiceException("Record not save successfully ",102);
        }
    }

    public ApplicationResponce updateRecord(Long id, DemuBearingRejectionData updatedRecord) throws ServiceException {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            DemuBearingRejectionData demuBearingRejectionData = repository.save(updatedRecord);
            if(demuBearingRejectionData!=null){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData("update record successfully");
                return applicationResponce;
            }
        }
        throw new ServiceException("record not found ",98);
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


    public Page<DemuBearingRejectionData> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
