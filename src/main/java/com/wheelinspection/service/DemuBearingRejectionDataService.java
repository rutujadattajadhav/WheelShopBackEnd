package com.wheelinspection.service;

import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.entity.DemuBearingRejectionData;
import com.wheelinspection.repository.DemuBearingRejectionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DemuBearingRejectionDataService {
    @Autowired
    private DemuBearingRejectionDataRepository repository;

    public List<DemuBearingRejectionData> getAllRecords() {
        return repository.findAll();
    }

    public Optional<DemuBearingRejectionData> getRecordById(Long id) {
        return repository.findById(id);
    }

    public DemuBearingRejectionData createRecord(DemuBearingRejectionData record) {
        return repository.save(record);
    }

    public DemuBearingRejectionData updateRecord(Long id, DemuBearingRejectionData updatedRecord) {
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


    public Page<DemuBearingRejectionData> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
