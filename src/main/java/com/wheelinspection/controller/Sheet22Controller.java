package com.wheelinspection.controller;

import com.wheelinspection.entity.Rard;
import com.wheelinspection.entity.Sheet22;
import com.wheelinspection.service.Sheet22Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sheet22")
public class Sheet22Controller {

    @Autowired
    private Sheet22Service service;

    @GetMapping("/getAllRecords")
    public List<Sheet22> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sheet22> getRecordById(@PathVariable Long id) {
        Optional<Sheet22> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sheet22 createRecord(@RequestBody Sheet22 record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sheet22> updateRecord(@PathVariable Long id, @RequestBody Sheet22 updatedRecord) {
        Sheet22 record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
       return service.deleteRecord(id);

    }


    @GetMapping
    public Page<Sheet22> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
