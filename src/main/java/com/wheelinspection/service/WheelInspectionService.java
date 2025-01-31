package com.wheelinspection.service;

import com.wheelinspection.model.WheelInspection;
import com.wheelinspection.repository.WheelInspectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WheelInspectionService {

    private final WheelInspectionRepository repository;

    public WheelInspectionService(WheelInspectionRepository repository) {
        this.repository = repository;
    }

    public List<WheelInspection> getAllInspections() {
        return repository.findAll();
    }

    public WheelInspection getInspectionById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Inspection not found"));
    }

    public WheelInspection addInspection(WheelInspection inspection) {
        return repository.save(inspection);
    }
}
