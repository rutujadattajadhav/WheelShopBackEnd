package com.wheelinspection.controller;

import com.wheelinspection.entity.DemuBearingRejectionData;
import com.wheelinspection.entity.FinalInspectionOfWheel;
import com.wheelinspection.service.FinalInspectionOfWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/final-inspection-of-wheel")
public class FinalInspectionOfWheelController {

    @Autowired
    private FinalInspectionOfWheelService service;

    @GetMapping("/getAllRecord")
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
    public String deleteRecord(@PathVariable Long id) {
      return  service.deleteRecord(id);

    }


    @GetMapping
    public Page<FinalInspectionOfWheel> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
