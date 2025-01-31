package com.wheelinspection.service;


import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.repository.BreakdownHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreakdownHistoryService {

    @Autowired
    private BreakdownHistoryRepository repository;

    public List<BreakdownHistory> getAllRecords() {
        return repository.findAll();
    }

    public BreakdownHistory getRecordById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public BreakdownHistory addOrUpdateRecord(BreakdownHistory record) {
        return repository.save(record);
    }

    public String deleteRecord(Long id) {
        repository.deleteById(id);
        return "delete successfully";
    }

    public Page<BreakdownHistory> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
