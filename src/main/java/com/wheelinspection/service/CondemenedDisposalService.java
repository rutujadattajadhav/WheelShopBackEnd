package com.wheelinspection.service;

import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.CondemenedDisposalRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CondemenedDisposalService {
    @Autowired
    private CondemenedDisposalRepository repository;

    public List<CondemenedDisposal> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws ServiceException {
        if (repository.existsById(id)) {
            Optional<CondemenedDisposal> condemenedDisposal = repository.findById(id);
            if (condemenedDisposal.isPresent()) {
                ApplicationResponce applicationResponce = new ApplicationResponce();
                applicationResponce.setData(condemenedDisposal);
                return applicationResponce;
            } else {
                throw new ServiceException("record not get successfully", 90);
            }
        }throw new ServiceException("record not found",90);

    }

    public ApplicationResponce createRecord(CondemenedDisposal record) throws ServiceException {
        CondemenedDisposal condemenedDisposal= repository.save(record);
        if(condemenedDisposal!=null){
            ApplicationResponce applicationResponce  =new ApplicationResponce();
            applicationResponce.setData(condemenedDisposal);
            return applicationResponce;
        }else{
            throw new ServiceException("not save successfully",203);
        }
    }

    public ApplicationResponce updateRecord(Long id, CondemenedDisposal updatedRecord) throws ServiceException {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            CondemenedDisposal condemenedDisposal = repository.save(updatedRecord);
            if(condemenedDisposal!=null){
                ApplicationResponce applicationResponce  =new ApplicationResponce();
                applicationResponce.setData(condemenedDisposal);
                return applicationResponce;
            }else{
                throw new ServiceException("not update successfully",203);
            }
        }
        throw new ServiceException("Record not found",190);
    }

    public ApplicationResponce deleteRecord(Long id) throws ServiceException {
        if(repository.existsById(id)){
            repository.deleteById(id);
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("delete successfully");
            return applicationResponce;
        }else{
            throw new ServiceException("Record not found",87);
        }

    }

    public Page<CondemenedDisposal> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
