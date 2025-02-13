package com.wheelinspection.service;

import com.wheelinspection.entity.WheelPoh;
import com.wheelinspection.entity.WheelPressOnDetail;
import com.wheelinspection.entity.WheelProfileAnalysis;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.model.WheelInspection;
import com.wheelinspection.repository.WheelProfileAnalysisRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WheelProfileAnalysisService {
    @Autowired
    private WheelProfileAnalysisRepository repository;

    public List<WheelProfileAnalysis> getAllRecords() {
        return repository.findAll();
    }

    public ApplicationResponce getRecordById(Long id) throws ServiceException {

        if(repository.existsById(id)){
            Optional<WheelProfileAnalysis> wheelInspection =repository.findById(id);
            if(wheelInspection.isPresent()){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData(wheelInspection);
                return applicationResponce;
            }
        }
        throw new ServiceException("Inspection not found",404);
    }

    public ApplicationResponce createRecord(WheelProfileAnalysis record) throws ServiceException {
        WheelProfileAnalysis wheelProfileAnalysis = repository.save(record);
        if(wheelProfileAnalysis!=null){
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("save Successfully");
            return applicationResponce;
        }
        throw new ServiceException("not save succsfully",500);
    }

    public WheelProfileAnalysis updateRecord(Long id, WheelProfileAnalysis updatedRecord) {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            return repository.save(updatedRecord);
        }
        return null;
    }

    public ApplicationResponce deleteRecord(Long id) throws ServiceException {

        Optional<WheelProfileAnalysis> detail = repository.findById(id);
        if(detail.isPresent()){
            repository.delete(detail.get());
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("delete successfully");
            return applicationResponce;
        }
        throw new ServiceException("detail not found",404);
    }


    public Page<WheelProfileAnalysis> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByPlantNnoNative(search, pageable);
    }
}
