package com.wheelinspection.controller;

import com.wheelinspection.entity.WheelPressOnDetail;
import com.wheelinspection.service.WheelPressOnDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wheel-press-on-detail")
public class WheelPressOnDetailController {

    @Autowired
    private WheelPressOnDetailService service;

    @GetMapping
    public List<WheelPressOnDetail> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WheelPressOnDetail> getRecordById(@PathVariable Long id) {
        Optional<WheelPressOnDetail> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public WheelPressOnDetail createRecord(@RequestBody WheelPressOnDetail record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WheelPressOnDetail> updateRecord(@PathVariable Long id, @RequestBody WheelPressOnDetail updatedRecord) {
        WheelPressOnDetail record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
