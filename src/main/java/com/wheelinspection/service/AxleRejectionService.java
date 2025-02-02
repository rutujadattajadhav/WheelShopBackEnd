package com.wheelinspection.service;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.repository.AxleRejectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AxleRejectionService {
    @Autowired
    private AxleRejectionRepository repository;

    public List<AxleRejection> getAllRecords() {
        return repository.findAll();
    }

    public Optional<AxleRejection> getRecordById(Long id) {
        return repository.findById(id);
    }

    public AxleRejection createRecord(AxleRejection record) {
        return repository.save(record);
    }

    public AxleRejection updateRecord(Long id, AxleRejection updatedRecord) {
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

    public Page<AxleRejection> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
