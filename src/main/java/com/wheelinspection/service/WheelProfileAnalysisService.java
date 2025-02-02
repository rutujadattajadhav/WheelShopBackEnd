package com.wheelinspection.service;

import com.wheelinspection.entity.WheelPressOnDetail;
import com.wheelinspection.entity.WheelProfileAnalysis;
import com.wheelinspection.repository.WheelProfileAnalysisRepository;
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

    public Optional<WheelProfileAnalysis> getRecordById(Long id) {
        return repository.findById(id);
    }

    public WheelProfileAnalysis createRecord(WheelProfileAnalysis record) {
        return repository.save(record);
    }

    public WheelProfileAnalysis updateRecord(Long id, WheelProfileAnalysis updatedRecord) {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            return repository.save(updatedRecord);
        }
        return null;
    }

    public String deleteRecord(Long id) {

        repository.deleteById(id);
        return "delete successfully";
    }


    public Page<WheelProfileAnalysis> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByPlantNnoNative(search, pageable);
    }
}
