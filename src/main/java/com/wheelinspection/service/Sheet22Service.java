package com.wheelinspection.service;

import com.wheelinspection.entity.Rard;
import com.wheelinspection.entity.Sheet22;
import com.wheelinspection.repository.Sheet22Repository;
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

    public Optional<Sheet22> getRecordById(Long id) {
        return repository.findById(id);
    }

    public Sheet22 createRecord(Sheet22 record) {
        return repository.save(record);
    }

    public Sheet22 updateRecord(Long id, Sheet22 updatedRecord) {
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


    public Page<Sheet22> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByPlantNnoNative(search, pageable);
    }
}
