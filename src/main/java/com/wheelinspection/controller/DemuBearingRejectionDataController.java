package com.wheelinspection.controller;

import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.entity.DemuBearingRejectionData;
import com.wheelinspection.service.DemuBearingRejectionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demu-bearing-rejection")
public class DemuBearingRejectionDataController {

    @Autowired
    private DemuBearingRejectionDataService service;

    @GetMapping("/getAllRecord")
    public List<DemuBearingRejectionData> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemuBearingRejectionData> getRecordById(@PathVariable Long id) {
        Optional<DemuBearingRejectionData> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DemuBearingRejectionData createRecord(@RequestBody DemuBearingRejectionData record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemuBearingRejectionData> updateRecord(@PathVariable Long id, @RequestBody DemuBearingRejectionData updatedRecord) {
        DemuBearingRejectionData record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
      return  service.deleteRecord(id);

    }


    @GetMapping
    public Page<DemuBearingRejectionData> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
