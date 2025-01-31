package com.wheelinspection.controller;

import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.entity.Machine;
import com.wheelinspection.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
@CrossOrigin("*")
public class MachineController {

    @Autowired
    private MachineService machineService;

    // Get all machines
    @GetMapping("/getAllMachine")
    public List<Machine> getAllMachines() {
        return machineService.getAllMachines();
    }

    // Get a single machine by ID
    @GetMapping("/{id}")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        Machine machine = machineService.getMachineById(id);
        return ResponseEntity.ok(machine);
    }

    // Add a new machine
    @PostMapping
    public ResponseEntity<Machine> addMachine(@RequestBody Machine machine) {
        Machine newMachine = machineService.addMachine(machine);
        return ResponseEntity.ok(newMachine);
    }

    // Update an existing machine
    @PutMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(@PathVariable Long id, @RequestBody Machine machineDetails) {
        Machine updatedMachine = machineService.updateMachine(id, machineDetails);
        return ResponseEntity.ok(updatedMachine);
    }

    // Delete a machine
    @DeleteMapping("/{id}")
    public String deleteMachine(@PathVariable Long id) {
        return  machineService.deleteMachine(id);

    }

    @GetMapping
    public Page<Machine > getMachines(@RequestParam(defaultValue = "") String search,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return machineService.getPaginatedData(search, PageRequest.of(page, size));
    }
}
