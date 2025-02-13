package com.wheelinspection.controller;

import com.wheelinspection.entity.Rard;
import com.wheelinspection.entity.Sheet22;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.responce.ApplicationResponce;
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
    public ApplicationResponce getRecordById(@PathVariable Long id) throws ServiceException {
        ApplicationResponce record = service.getRecordById(id);
        return record;
    }

    @PostMapping
    public ApplicationResponce createRecord(@RequestBody Sheet22 record) throws ServiceException {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponce> updateRecord(@PathVariable Long id, @RequestBody Sheet22 updatedRecord) throws ServiceException {
        ApplicationResponce record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ApplicationResponce deleteRecord(@PathVariable Long id) throws ServiceException {
       return service.deleteRecord(id);

    }


    @GetMapping
    public Page<Sheet22> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
