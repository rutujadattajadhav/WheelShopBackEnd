package com.wheelinspection.service;

import com.wheelinspection.entity.Rard;
import com.wheelinspection.entity.Sheet22;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.Sheet22Repository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Sheet22Service {
    @Autowired
    private Sheet22Repository repository;

    public List<Sheet22> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws ServiceException {
        if(repository.existsById(id)) {
            Optional<Sheet22> sheet22 = repository.findById(id);
            if(sheet22.isPresent()){
                ApplicationResponce applicationResponce   =new ApplicationResponce();
                applicationResponce.setData(sheet22);
                return applicationResponce;
            }
        }
        throw new ServiceException("Record not found",404);
    }

    public ApplicationResponce createRecord(Sheet22 record) throws ServiceException {
        Sheet22 sheet22 = repository.save(record);
        if(sheet22!=null){
            ApplicationResponce applicationResponce=new ApplicationResponce();
            applicationResponce.setData("Record save Successfully");
            return applicationResponce;
        }
        throw new ServiceException("not save sucessfully",500);
    }

    public ApplicationResponce updateRecord(Long id, Sheet22 updatedRecord) throws ServiceException {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            Sheet22 sheet22 = repository.save(updatedRecord);
            if(sheet22!=null){
                ApplicationResponce applicationResponce=new ApplicationResponce();
                applicationResponce.setData("Record save Successfully");
                return applicationResponce;
            }
        }
        throw new ServiceException("Record not found",404);
    }

    public ApplicationResponce deleteRecord(Long id) throws ServiceException {
        if(repository.existsById(id)){
            repository.deleteById(id);
            ApplicationResponce applicationResponce=new ApplicationResponce();
            applicationResponce.setData("delete successfully");
            return applicationResponce;
        }
         throw new ServiceException("",404);
    }


    public Page<Sheet22> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByPlantNnoNative(search, pageable);
    }
}
