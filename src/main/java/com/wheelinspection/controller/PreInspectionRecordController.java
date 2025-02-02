package com.wheelinspection.controller;

import com.wheelinspection.entity.FinalInspectionOfWheel;
import com.wheelinspection.entity.PreInspectionRecord;
import com.wheelinspection.service.PreInspectionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pre-inspection-records")
public class PreInspectionRecordController {

    @Autowired
    private PreInspectionRecordService service;

    @GetMapping("/getAllRecord")
    public List<PreInspectionRecord> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreInspectionRecord> getRecordById(@PathVariable Long id) {
        Optional<PreInspectionRecord> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PreInspectionRecord createRecord(@RequestBody PreInspectionRecord record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreInspectionRecord> updateRecord(@PathVariable Long id, @RequestBody PreInspectionRecord updatedRecord) {
        PreInspectionRecord record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        return  service.deleteRecord(id);

    }


    @GetMapping
    public Page<PreInspectionRecord> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
