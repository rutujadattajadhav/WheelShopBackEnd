package com.wheelinspection.controller;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.responce.ApplicationResponce;
import com.wheelinspection.service.AxleRejectionService;
//import com.wheelinspection.validation.axleRejectionValidation.SaveValidation;
import com.wheelinspection.validation.axleRejectionValidation.SaveValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/axle-rejection")
public class AxleRejectionController {

    @Autowired
    private AxleRejectionService service;

    @Autowired
    private SaveValidation saveValidation;

    @GetMapping("/getAllRecord")
    public List<AxleRejection> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponce> getRecordById(@PathVariable Long id) throws ServiceException, Exception {
        Optional<ApplicationResponce> record = Optional.ofNullable(service.getRecordById(id));
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ApplicationResponce createRecord(@RequestBody AxleRejection record) throws Exception {
        saveValidation.validate(record);
        return service.createRecord(record);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponce> updateRecord(@PathVariable Long id, @RequestBody AxleRejection updatedRecord) throws Exception {
        saveValidation.validate(updatedRecord);
        ApplicationResponce record = service.updateRecord(id, updatedRecord);

        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ApplicationResponce deleteRecord(@PathVariable Long id) throws Exception {
       return service.deleteRecord(id);

    }

    @GetMapping
    public Page<AxleRejection> getBreakdowns(@RequestParam() String search,
                                                @RequestParam() int page,
                                                @RequestParam() int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
