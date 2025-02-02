package com.wheelinspection.service;

import com.wheelinspection.entity.PreInspectionRecord;
import com.wheelinspection.repository.PreInspectionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<PreInspectionRecord> getRecordById(Long id) {
        return repository.findById(id);
    }

    public PreInspectionRecord createRecord(PreInspectionRecord record) {
        return repository.save(record);
    }

    public PreInspectionRecord updateRecord(Long id, PreInspectionRecord updatedRecord) {
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
