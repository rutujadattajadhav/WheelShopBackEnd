package com.wheelinspection.controller;

import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.service.BreakdownHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breakdown")
public class BreakdownHistoryController {

    @Autowired
    private BreakdownHistoryService service;

    @GetMapping(value = "/allRecords")
    public List<BreakdownHistory> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreakdownHistory> getRecordById(@PathVariable Long id) {
        BreakdownHistory record = service.getRecordById(id);
        if (record != null) {
            return ResponseEntity.ok(record);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public BreakdownHistory addOrUpdateRecord(@RequestBody BreakdownHistory record) {
        return service.addOrUpdateRecord(record);
    }

    @PutMapping("/{id}")
    public BreakdownHistory updateRecord(@PathVariable Long id, @RequestBody BreakdownHistory record) {
        record.setId(id);
        return service.addOrUpdateRecord(record);
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        return  service.deleteRecord(id);

    }

    @GetMapping
    public Page<BreakdownHistory> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
