package com.wheelinspection.service;


import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.BreakdownHistoryRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreakdownHistoryService {

    @Autowired
    private BreakdownHistoryRepository repository;

    public List<BreakdownHistory> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws ServiceException {
       Optional<BreakdownHistory> breakdownHistory =repository.findById(id);
       if(breakdownHistory.isPresent()){
           ApplicationResponce applicationResponce =new ApplicationResponce();
           applicationResponce.setData(breakdownHistory);
           return applicationResponce;
       }else{
           throw new ServiceException("record not found",34);
       }
    }

    public ApplicationResponce addOrUpdateRecord(BreakdownHistory record) throws ServiceException {

        BreakdownHistory breakdownHistory = repository.save(record);
        if(breakdownHistory!=null){
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("Save or Update successfully");
            return applicationResponce;
        }else{
            throw new ServiceException("not save or update successfully",103);
        }
    }

    public ApplicationResponce deleteRecord(Long id) throws ServiceException {
        if(repository.existsById(id)){
            repository.deleteById(id);
            ApplicationResponce applicationResponce  =new ApplicationResponce();
            applicationResponce.setData("delete successfully");
            return applicationResponce;
        }else{
            throw new ServiceException("Record not found",102);
        }

    }

    public Page<BreakdownHistory> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
