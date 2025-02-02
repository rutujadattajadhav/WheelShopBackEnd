package com.wheelinspection.service;

import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.repository.CondemenedDisposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CondemenedDisposalService {
    @Autowired
    private CondemenedDisposalRepository repository;

    public List<CondemenedDisposal> getAllRecords() {
        return repository.findAll();
    }

    public Optional<CondemenedDisposal> getRecordById(Long id) {
        return repository.findById(id);
    }

    public CondemenedDisposal createRecord(CondemenedDisposal record) {
        return repository.save(record);
    }

    public CondemenedDisposal updateRecord(Long id, CondemenedDisposal updatedRecord) {
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

    public Page<CondemenedDisposal> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByVehicleNative(search, pageable);
    }
}
