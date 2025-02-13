package com.wheelinspection.controller;

import com.wheelinspection.entity.DemuBearingRejectionData;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.responce.ApplicationResponce;
import com.wheelinspection.service.DemuBearingRejectionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ApplicationResponce getRecordById(@PathVariable Long id) throws ServiceException {
        ApplicationResponce record = service.getRecordById(id);
        return record;
    }

    @PostMapping
    public ApplicationResponce createRecord(@RequestBody DemuBearingRejectionData record) throws ServiceException {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponce> updateRecord(@PathVariable Long id, @RequestBody DemuBearingRejectionData updatedRecord) throws ServiceException {
        ApplicationResponce record = service.updateRecord(id, updatedRecord);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ApplicationResponce deleteRecord(@PathVariable Long id) throws ServiceException {
      return  service.deleteRecord(id);

    }


    @GetMapping
    public Page<DemuBearingRejectionData> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
