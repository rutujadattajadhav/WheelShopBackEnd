package com.wheelinspection.service;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.error.WheelInspectionError;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.AxleRejectionRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AxleRejectionService {
    @Autowired
    private AxleRejectionRepository repository;

    public List<AxleRejection> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws Exception {
        ApplicationResponce applicationResponce   = new ApplicationResponce();
        Optional<AxleRejection>  axleRejection=repository.findById(id);
        if(axleRejection.isPresent()){
            applicationResponce.setData(axleRejection.get());
            return  applicationResponce;

        }else{
            throw new ServiceException("Axel record not found",102);
        }
    }

    public ApplicationResponce createRecord(AxleRejection record) throws Exception {
        AxleRejection axleRejection = repository.save(record);
        if(axleRejection!=null){
            ApplicationResponce applicationResponce  =new ApplicationResponce();
            applicationResponce.setData(axleRejection);
            return applicationResponce;
        }else{
            throw new ServiceException("record not save successfully",103);
        }
    }

    public ApplicationResponce updateRecord(Long id, AxleRejection updatedRecord) throws Exception {
        if (repository.existsById(id)) {
            updatedRecord.setAxleNo(id+"");
            AxleRejection axleRejection = repository.save(updatedRecord);
            if(axleRejection!=null){
                ApplicationResponce applicationResponce  =new ApplicationResponce();
                applicationResponce.setData(axleRejection);
                return applicationResponce;
            }
        }
        throw new ServiceException("not updated successfully",103);
    }

    public ApplicationResponce deleteRecord(Long id) throws Exception {
        if (repository.existsById(id)){
            repository.deleteById(id);
            ApplicationResponce applicationResponce  =new ApplicationResponce();
            applicationResponce.setData("delete successfully");
            return applicationResponce;
        }else{
          throw  new ServiceException("record not found",3);
        }
    }

    public Page<AxleRejection> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search,pageable);
    }
}
