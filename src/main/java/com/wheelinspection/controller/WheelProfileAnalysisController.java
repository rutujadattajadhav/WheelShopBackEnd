package com.wheelinspection.controller;

import com.wheelinspection.entity.WheelPoh;
import com.wheelinspection.entity.WheelProfileAnalysis;
import com.wheelinspection.service.WheelProfileAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wheel-process-analysis")
public class WheelProfileAnalysisController {

    @Autowired
    private WheelProfileAnalysisService service;

    @GetMapping("/getAllRecord")
    public List<WheelProfileAnalysis> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WheelProfileAnalysis> getRecordById(@PathVariable Long id) {
        Optional<WheelProfileAnalysis> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public WheelProfileAnalysis createRecord(@RequestBody WheelProfileAnalysis record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WheelProfileAnalysis> updateRecord(@PathVariable Long id, @RequestBody WheelProfileAnalysis updatedRecord) {
        WheelProfileAnalysis record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        return service.deleteRecord(id);

    }

    @GetMapping
    public Page<WheelProfileAnalysis> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
