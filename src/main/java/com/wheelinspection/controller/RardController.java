package com.wheelinspection.controller;

import com.wheelinspection.entity.PreInspectionRecord;
import com.wheelinspection.entity.Rard;
import com.wheelinspection.service.RardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rard")
public class RardController {

    @Autowired
    private RardService service;

    @GetMapping("/getAllRecords")
    public List<Rard> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rard> getRecordById(@PathVariable Long id) {
        Optional<Rard> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rard createRecord(@RequestBody Rard record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rard> updateRecord(@PathVariable Long id, @RequestBody Rard updatedRecord) {
        Rard record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        return  service.deleteRecord(id);

    }


    @GetMapping
    public Page<Rard> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
