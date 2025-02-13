package com.wheelinspection.service;

import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.entity.Machine;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.repository.MachineRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    public ApplicationResponce getMachineById(Long id) throws ServiceException {
        if(machineRepository.existsById(id)){
            Optional<Machine> machine =machineRepository.findById(id);
            if(machine.isPresent()){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData(machine);
                return applicationResponce;
            }
        }
        throw new ServiceException("machine not found",104);
    }

    public ApplicationResponce addMachine(Machine machine) throws ServiceException {
        Machine machine1  = machineRepository.save(machine);
        if(machine1!=null){
            ApplicationResponce applicationResponce=new ApplicationResponce();
            applicationResponce.setData("save Machine Successfully");
            return applicationResponce;
        }else{
            throw new ServiceException("Machine not save successfully",46);
        }
    }

    public ApplicationResponce updateMachine(Long id, Machine machineDetails) throws ServiceException {
        // Fetch the machine from the database
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Machine with ID " + id + " not found", 404));

        // Update machine details
        machine.setPlantNo(machineDetails.getPlantNo());
        machine.setDescription(machineDetails.getDescription());
        machine.setMake(machineDetails.getMake());
        machine.setAcquisitionDate(machineDetails.getAcquisitionDate());
        machine.setCapacity(machineDetails.getCapacity());

        // Save the updated machine
        Machine updatedMachine = machineRepository.save(machine);

        // Check if the save operation was successful
        if (updatedMachine != null) {
            ApplicationResponce applicationResponse = new ApplicationResponce();
            applicationResponse.setData("Machine updated successfully");
            return applicationResponse;
        }

        throw new ServiceException("Machine update failed", 500);
    }


    public ApplicationResponce deleteMachine(Long id) throws ServiceException {
      Optional <Machine> machine = machineRepository.findById(id);
      if(machine.isPresent()){
          machineRepository.delete(machine.get());
          ApplicationResponce applicationResponce =new ApplicationResponce();
          applicationResponce.setData("Delete successfully");
          return applicationResponce;
      }
        else{
          throw new ServiceException("Machine with ID " + id + " not found",67);
      }
    }


    public Page<Machine> getPaginatedData(String search, Pageable pageable) {
        return machineRepository.searchByPlantNnoNative(search, pageable);
    }
}
