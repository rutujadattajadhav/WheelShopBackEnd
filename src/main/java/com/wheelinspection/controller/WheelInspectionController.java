package com.wheelinspection.controller;

import com.wheelinspection.model.WheelInspection;
import com.wheelinspection.service.WheelInspectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wheel-inspections")
public class WheelInspectionController {

    private final WheelInspectionService service;

    public WheelInspectionController(WheelInspectionService service) {
        this.service = service;
    }

    @GetMapping
    public List<WheelInspection> getAllInspections() {
        return service.getAllInspections();
    }

    @GetMapping("/{id}")
    public WheelInspection getInspectionById(@PathVariable Long id) {
        return service.getInspectionById(id);
    }

    @PostMapping
    public WheelInspection addInspection(@RequestBody WheelInspection inspection) {
        return service.addInspection(inspection);
    }


}
