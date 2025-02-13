package com.wheelinspection.service;

import com.wheelinspection.entity.Machine;
import com.wheelinspection.entity.PreInspectionRecord;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.PreInspectionRecordRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PreInspectionRecordService {
    @Autowired
    private PreInspectionRecordRepository repository;

    public List<PreInspectionRecord> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws ServiceException {
        if(repository.existsById(id)){
           Optional<PreInspectionRecord>  preInspectionRecord  = repository.findById(id);
           if(preInspectionRecord.isPresent()){
               ApplicationResponce applicationResponce =new ApplicationResponce();
               applicationResponce.setData(preInspectionRecord);
               return applicationResponce;
           }
        }
            throw new ServiceException("Record not found",404);
    }

    public ApplicationResponce createRecord(PreInspectionRecord record) throws ServiceException {
        PreInspectionRecord preInspectionRecord  =repository.save(record);
        if(preInspectionRecord!=null){
            ApplicationResponce applicationResponce  =new ApplicationResponce();
            applicationResponce.setData("save record successfully");
            return applicationResponce;
        }else{
            throw new ServiceException("not save successfully",500);
        }
    }

    public ApplicationResponce updateRecord(Long id, PreInspectionRecord updatedRecord) throws ServiceException {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            PreInspectionRecord preInspectionRecord = repository.save(updatedRecord);
            if(preInspectionRecord!=null){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData("Update successfully");
                return applicationResponce;
            }
        }
        throw new ServiceException("Record Not found",500);
    }

    public ApplicationResponce deleteRecord(Long id) throws ServiceException {
        if(repository.existsById(id)){
            repository.deleteById(id);
            ApplicationResponce applicationResponce=new ApplicationResponce();
            applicationResponce.setData("Delete successfully");
            return applicationResponce;
        }
        else{
            throw new ServiceException("Record not found",404);
        }
    }


    public Page<PreInspectionRecord> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByPlantNnoNative(search, pageable);
    }
}
