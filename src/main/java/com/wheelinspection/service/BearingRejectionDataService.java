package com.wheelinspection.service;

import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.error.WheelInspectionError;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.BearingRejectionDataRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BearingRejectionDataService {
    @Autowired
    private BearingRejectionDataRepository repository;

    public List<BearingRejectionData> getAllRecords() {
        return repository.findAll();
    }

    public Optional<BearingRejectionData> getRecordById(Long id) throws ServiceException {
        Optional<BearingRejectionData> bearingRejectionData=repository.findById(id);
        if(bearingRejectionData.isPresent()){
            return bearingRejectionData;
        }
        else{
            throw new ServiceException("Record not found",90);
        }
    }

    public ApplicationResponce createRecord(BearingRejectionData record) throws ServiceException {
        BearingRejectionData bearingRejectionData=  repository.save(record);
        if(bearingRejectionData!=null){
            ApplicationResponce applicationResponce  =new ApplicationResponce();
            applicationResponce.setData(bearingRejectionData);
            return applicationResponce;
        }else{
            throw new ServiceException("record not save successfully",102);
        }

    }

    public ApplicationResponce updateRecord(Long id, BearingRejectionData updatedRecord) throws ServiceException {
        if (repository.existsById(id)) {
            updatedRecord.setBearingNo(id+"");
            BearingRejectionData bearingRejectionData = repository.save(updatedRecord);
            if(bearingRejectionData!=null){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData(bearingRejectionData);
                return applicationResponce;
            }else{
                throw new ServiceException("not update successfully",108);
            }
        }
        throw new ServiceException("Record not found",4);
    }

    public ApplicationResponce deleteRecord(Long id) throws ServiceException {
        if(repository.existsById(id)){
            repository.deleteById(id);
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("delete successfully");
            return applicationResponce;
        }else{
            throw new ServiceException("not delete successfully",500);
        }

    }

    public Page<BearingRejectionData> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
