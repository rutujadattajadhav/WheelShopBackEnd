package com.wheelinspection.service;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.repository.BearingRejectionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BearingRejectionDataService {
    @Autowired
    private BearingRejectionDataRepository repository;

    public List<BearingRejectionData> getAllRecords() {
        return repository.findAll();
    }

    public Optional<BearingRejectionData> getRecordById(Long id) {
        return repository.findById(id);
    }

    public BearingRejectionData createRecord(BearingRejectionData record) {
        return repository.save(record);
    }

    public BearingRejectionData updateRecord(Long id, BearingRejectionData updatedRecord) {
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

    public Page<BearingRejectionData> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
