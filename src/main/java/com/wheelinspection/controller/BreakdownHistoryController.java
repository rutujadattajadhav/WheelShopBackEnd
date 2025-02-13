package com.wheelinspection.controller;

import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.handler.ValidationException;
import com.wheelinspection.responce.ApplicationResponce;
import com.wheelinspection.service.BreakdownHistoryService;
import com.wheelinspection.validation.breakDownHistoryValidation.BreakDownHistorySaveValidation;
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

    @Autowired
    private BreakDownHistorySaveValidation saveValidation;

    @GetMapping(value = "/allRecords")
    public List<BreakdownHistory> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponce> getRecordById(@PathVariable Long id) throws ServiceException {
        ApplicationResponce record = service.getRecordById(id);
        if (record != null) {
            return ResponseEntity.ok(record);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ApplicationResponce addOrUpdateRecord(@RequestBody BreakdownHistory record) throws ServiceException, ValidationException {
        saveValidation.validate(record);
        return service.addOrUpdateRecord(record);
    }

    @PutMapping("/{id}")
    public ApplicationResponce updateRecord(@PathVariable Long id, @RequestBody BreakdownHistory record) throws ServiceException, ValidationException {
        saveValidation.validate(record);
        record.setId(id);
        return service.addOrUpdateRecord(record);
    }

    @DeleteMapping("/{id}")
    public ApplicationResponce deleteRecord(@PathVariable Long id) throws ServiceException {
        return  service.deleteRecord(id);

    }

    @GetMapping
    public Page<BreakdownHistory> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
