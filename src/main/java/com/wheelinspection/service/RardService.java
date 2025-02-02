package com.wheelinspection.service;

import com.wheelinspection.entity.PreInspectionRecord;
import com.wheelinspection.entity.Rard;
import com.wheelinspection.repository.RardRepository;
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

    public Optional<Rard> getRecordById(Long id) {
        return repository.findById(id);
    }

    public Rard createRecord(Rard record) {
        return repository.save(record);
    }

    public Rard updateRecord(Long id, Rard updatedRecord) {
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



    public Page<Rard> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByPlantNnoNative(search, pageable);
    }
}
