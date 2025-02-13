package com.wheelinspection.controller;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.handler.ValidationException;
import com.wheelinspection.responce.ApplicationResponce;
import com.wheelinspection.service.BearingRejectionDataService;

import com.wheelinspection.validation.bearingRejectionValidation.BearingRejectionSaveValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bearing-rejection-data")
public class BearingRejectionDataController {

    @Autowired
    private BearingRejectionDataService service;

    @Autowired
    private BearingRejectionSaveValidation saveValidation;

    @GetMapping("/getAllRecord")
    public List<BearingRejectionData> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BearingRejectionData> getRecordById(@PathVariable Long id) throws ServiceException {
        Optional<BearingRejectionData> record = service.getRecordById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ApplicationResponce createRecord(@RequestBody BearingRejectionData record) throws ValidationException, ServiceException {
        saveValidation.validate(record);
        return service.createRecord(record);
           }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponce> updateRecord(@PathVariable Long id, @RequestBody BearingRejectionData updatedRecord) throws ServiceException, ValidationException {
        saveValidation.validate(updatedRecord);
        ApplicationResponce record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ApplicationResponce deleteRecord(@PathVariable Long id) throws ServiceException {
        return service.deleteRecord(id);

    }

    @GetMapping
    public Page<BearingRejectionData> getBreakdowns(@RequestParam() String search,
                                             @RequestParam() int page,
                                             @RequestParam() int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
