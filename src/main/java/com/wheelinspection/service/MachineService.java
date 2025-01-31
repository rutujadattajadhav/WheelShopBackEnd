package com.wheelinspection.service;

import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.entity.Machine;
import com.wheelinspection.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    public Machine getMachineById(Long id) {
        return machineRepository.findById(id).orElseThrow(() -> new RuntimeException("Machine not found"));
    }

    public Machine addMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    public Machine updateMachine(Long id, Machine machineDetails) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        machine.setPlantNo(machineDetails.getPlantNo());
        machine.setDescription(machineDetails.getDescription());
        machine.setMake(machineDetails.getMake());
        machine.setAcquisitionDate(machineDetails.getAcquisitionDate());
        machine.setCapacity(machineDetails.getCapacity());

        return machineRepository.save(machine);
    }

    public String deleteMachine(Long id) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Machine not found"));
        machineRepository.delete(machine);
        return "Delete succesfully";
    }


    public Page<Machine> getPaginatedData(String search, Pageable pageable) {
        return machineRepository.searchByPlantNnoNative(search, pageable);
    }
}
