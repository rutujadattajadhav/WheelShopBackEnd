package com.wheelinspection.controller;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.service.AxleRejectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/axle-rejection")
public class AxleRejectionController {

    @Autowired
    private AxleRejectionService service;

    @GetMapping("/getAllRecord")
    public List<AxleRejection> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AxleRejection> getRecordById(@PathVariable Long id) {
        Optional<AxleRejection> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AxleRejection createRecord(@RequestBody AxleRejection record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AxleRejection> updateRecord(@PathVariable Long id, @RequestBody AxleRejection updatedRecord) {
        AxleRejection record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
       return service.deleteRecord(id);

    }

    @GetMapping
    public Page<AxleRejection> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
