package com.wheelinspection.controller;

import com.wheelinspection.entity.Sheet22;
import com.wheelinspection.entity.WheelPoh;
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
    public ResponseEntity<WheelPoh> getDetailById(@ PathVariable Long id) {
        return ResponseEntity.ok(service.getDetailById(id));
    }

    @PostMapping
    public ResponseEntity<WheelPoh> addDetail(@RequestBody WheelPoh detail) {
        return ResponseEntity.ok(service.addDetail(detail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WheelPoh> updateDetail(@PathVariable Long id, @RequestBody WheelPoh detail) {
        return ResponseEntity.ok(service.updateDetail(id, detail));
    }

    @DeleteMapping("/{id}")
    public String deleteDetail(@PathVariable Long id) {
        return service.deleteDetail(id);

    }

    @GetMapping
    public Page<WheelPoh> getBreakdowns(@RequestParam(defaultValue = "") String search,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedData(search, PageRequest.of(page, size));
    }
}
