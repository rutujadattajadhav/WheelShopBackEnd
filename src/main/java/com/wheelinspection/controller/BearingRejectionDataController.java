package com.wheelinspection.controller;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.service.BearingRejectionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bearing-rejection-data")
public class BearingRejectionDataController {

    @Autowired
    private BearingRejectionDataService service;

    @GetMapping("/getAllRecord")
    public List<BearingRejectionData> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BearingRejectionData> getRecordById(@PathVariable Long id) {
        Optional<BearingRejectionData> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BearingRejectionData createRecord(@RequestBody BearingRejectionData record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BearingRejectionData> updateRecord(@PathVariable Long id, @RequestBody BearingRejectionData updatedRecord) {
        BearingRejectionData record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        return service.deleteRecord(id);

    }

    @GetMapping
    public Page<BearingRejectionData> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
