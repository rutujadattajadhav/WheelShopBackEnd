package com.wheelinspection.controller;

import com.wheelinspection.entity.FinalInspectionOfWheel;
import com.wheelinspection.service.FinalInspectionOfWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/final-inspection-of-wheel")
public class FinalInspectionOfWheelController {

    @Autowired
    private FinalInspectionOfWheelService service;

    @GetMapping
    public List<FinalInspectionOfWheel> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinalInspectionOfWheel> getRecordById(@PathVariable Long id) {
        Optional<FinalInspectionOfWheel> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public FinalInspectionOfWheel createRecord(@RequestBody FinalInspectionOfWheel record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinalInspectionOfWheel> updateRecord(@PathVariable Long id, @RequestBody FinalInspectionOfWheel updatedRecord) {
        FinalInspectionOfWheel record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
