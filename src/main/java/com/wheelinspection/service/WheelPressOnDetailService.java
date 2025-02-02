package com.wheelinspection.service;

import com.wheelinspection.entity.WheelPressOnDetail;
import com.wheelinspection.repository.WheelPressOnDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WheelPressOnDetailService {
    @Autowired
    private WheelPressOnDetailRepository repository;

    public List<WheelPressOnDetail> getAllRecords() {
        return repository.findAll();
    }

    public Optional<WheelPressOnDetail> getRecordById(Long id) {
        return repository.findById(id);
    }

    public WheelPressOnDetail createRecord(WheelPressOnDetail record) {
        return repository.save(record);
    }

    public WheelPressOnDetail updateRecord(Long id, WheelPressOnDetail updatedRecord) {
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
