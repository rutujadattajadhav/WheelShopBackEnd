package com.wheelinspection.controller;

import com.wheelinspection.entity.Sheet22;
import com.wheelinspection.entity.WheelPoh;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.responce.ApplicationResponce;
import com.wheelinspection.service.WheelPohService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wheel-poh")
@CrossOrigin("*")
public class WheelPohController {

    @Autowired
    private WheelPohService service;

    @GetMapping("/getAllDetails")
    public List<WheelPoh> getAllDetails() {
        return service.getAllDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponce> getDetailById(@ PathVariable Long id) throws ServiceException {
        return ResponseEntity.ok(service.getDetailById(id));
    }

    @PostMapping
    public ResponseEntity<ApplicationResponce> addDetail(@RequestBody WheelPoh detail) throws ServiceException {
        return ResponseEntity.ok(service.addDetail(detail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponce> updateDetail(@PathVariable Long id, @RequestBody WheelPoh detail) throws ServiceException {
        return ResponseEntity.ok(service.updateDetail(id, detail));
    }

    @DeleteMapping("/{id}")
    public ApplicationResponce deleteDetail(@PathVariable Long id) throws ServiceException {
        return service.deleteDetail(id);

    }

    @GetMapping
    public Page<WheelPoh> getBreakdowns(@RequestParam() String search,
                                       @RequestParam() int page,
                                       @RequestParam() int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
