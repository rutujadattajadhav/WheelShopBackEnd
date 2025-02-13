package com.wheelinspection.controller;

import com.wheelinspection.entity.WheelPressOnDetail;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.responce.ApplicationResponce;
import com.wheelinspection.service.WheelPressOnDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wheel-press-on-detail")
public class WheelPressOnDetailController {

    @Autowired
    private WheelPressOnDetailService service;

    @GetMapping("/getAllRecord")
    public List<WheelPressOnDetail> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ApplicationResponce getRecordById(@PathVariable Long id) throws ServiceException {
        ApplicationResponce record = service.getRecordById(id);
        return record;
    }

    @PostMapping
    public ApplicationResponce createRecord(@RequestBody WheelPressOnDetail record) throws ServiceException {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public WheelPressOnDetail updateRecord(@PathVariable Long id, @RequestBody WheelPressOnDetail updatedRecord) {
        WheelPressOnDetail record = service.updateRecord(id, updatedRecord);
        return record ;
    }

    @DeleteMapping("/{id}")
    public ApplicationResponce deleteRecord(@PathVariable Long id) throws ServiceException {
        return  service.deleteRecord(id);

    }

    @GetMapping
    public Page<WheelPressOnDetail> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
