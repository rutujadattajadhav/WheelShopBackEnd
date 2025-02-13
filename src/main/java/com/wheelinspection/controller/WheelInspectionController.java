package com.wheelinspection.controller;

import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.model.WheelInspection;
import com.wheelinspection.responce.ApplicationResponce;
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
    public ApplicationResponce getInspectionById(@PathVariable Long id) throws ServiceException {
        return service.getInspectionById(id);

    }

    @PostMapping
    public ApplicationResponce addInspection(@RequestBody WheelInspection inspection) throws ServiceException {
        return service.addInspection(inspection);
    }


}
