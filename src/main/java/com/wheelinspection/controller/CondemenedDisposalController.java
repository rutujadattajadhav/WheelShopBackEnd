package com.wheelinspection.controller;

import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.responce.ApplicationResponce;
import com.wheelinspection.service.CondemenedDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condemened-disposal")
public class CondemenedDisposalController {

    @Autowired
    private CondemenedDisposalService service;

    @GetMapping("/getAllRecords")
    public List<CondemenedDisposal> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ApplicationResponce getRecordById(@PathVariable Long id) throws ServiceException {
        ApplicationResponce record = service.getRecordById(id);
        return record;
    }

    @PostMapping
    public ApplicationResponce createRecord(@RequestBody CondemenedDisposal record) throws ServiceException {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponce> updateRecord(@PathVariable Long id, @RequestBody CondemenedDisposal updatedRecord) throws ServiceException {

        ApplicationResponce record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ApplicationResponce deleteRecord(@PathVariable Long id) throws ServiceException {
       return service.deleteRecord(id);

    }

    @GetMapping
    public Page<CondemenedDisposal> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
