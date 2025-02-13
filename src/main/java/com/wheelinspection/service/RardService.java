package com.wheelinspection.service;

import com.wheelinspection.entity.PreInspectionRecord;
import com.wheelinspection.entity.Rard;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.RardRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RardService {
    @Autowired
    private RardRepository repository;

    public List<Rard> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws ServiceException {
        if(repository.existsById(id)){
             Optional<Rard> rard=repository.findById(id);
             if(rard.isPresent()){
                 ApplicationResponce applicationResponce=new ApplicationResponce();
                 applicationResponce.setData(rard);
                 return applicationResponce;
             }
        }
        throw new ServiceException("Record not found",404);
    }

    public ApplicationResponce createRecord(Rard record) throws ServiceException {
       Rard rard = repository.save(record);
       if(rard!=null){
           ApplicationResponce applicationResponce =new ApplicationResponce();
           applicationResponce.setData("Save Successfully");
           return applicationResponce;
       }
       else{
           throw new ServiceException("not save succsfully",500);
       }
    }

    public ApplicationResponce updateRecord(Long id, Rard updatedRecord) throws ServiceException {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            Rard rard=repository.save(updatedRecord);
            if(rard!=null){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData("update Successfully");
                return applicationResponce;
            }
        }
        throw new ServiceException("not update successfully",500);
    }

    public ApplicationResponce deleteRecord(Long id) throws ServiceException {
        if(repository.existsById(id)){
            repository.deleteById(id);
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("update Successfully");
            return applicationResponce;
        }
        throw new ServiceException("Record not found",404);
    }



    public Page<Rard> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByPlantNnoNative(search, pageable);
    }
}
