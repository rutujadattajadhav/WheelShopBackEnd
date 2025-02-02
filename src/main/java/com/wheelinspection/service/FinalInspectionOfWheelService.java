package com.wheelinspection.service;

import com.wheelinspection.entity.FinalInspectionOfWheel;
import com.wheelinspection.repository.FinalInspectionOfWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FinalInspectionOfWheelService {
    @Autowired
    private FinalInspectionOfWheelRepository repository;

    public List<FinalInspectionOfWheel> getAllRecords() {
        return repository.findAll();
    }

    public Optional<FinalInspectionOfWheel> getRecordById(Long id) {
        return repository.findById(id);
    }

    public FinalInspectionOfWheel createRecord(FinalInspectionOfWheel record) {
        return repository.save(record);
    }

    public FinalInspectionOfWheel updateRecord(Long id, FinalInspectionOfWheel updatedRecord) {
        if (repository.existsById(id)) {
            updatedRecord.setId(id);
            return repository.save(updatedRecord);
        }
        return null;
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}
