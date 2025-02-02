package com.wheelinspection.controller;

import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.service.CondemenedDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/condemened-disposal")
public class CondemenedDisposalController {

    @Autowired
    private CondemenedDisposalService service;

    @GetMapping("/getAllRecords")
    public List<CondemenedDisposal> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondemenedDisposal> getRecordById(@PathVariable Long id) {
        Optional<CondemenedDisposal> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CondemenedDisposal createRecord(@RequestBody CondemenedDisposal record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondemenedDisposal> updateRecord(@PathVariable Long id, @RequestBody CondemenedDisposal updatedRecord) {
        CondemenedDisposal record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
       return service.deleteRecord(id);

    }

    @GetMapping
    public Page<CondemenedDisposal> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
