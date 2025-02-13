package com.wheelinspection.service;

import com.wheelinspection.entity.Sheet22;
import com.wheelinspection.entity.WheelPoh;
import com.wheelinspection.handler.ServiceException;
import com.wheelinspection.model.WheelInspection;
import com.wheelinspection.repository.WheelPohRepository;
import com.wheelinspection.responce.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WheelPohService {

    @Autowired
    private WheelPohRepository repository;

    public List<WheelPoh> getAllDetails() {
        return repository.findAll();
    }

    public ApplicationResponce getDetailById(Long id) throws ServiceException {
        if(repository.existsById(id)){
            Optional<WheelPoh> wheelInspection =repository.findById(id);
            if(wheelInspection.isPresent()){
                ApplicationResponce applicationResponce =new ApplicationResponce();
                applicationResponce.setData(wheelInspection);
                return applicationResponce;
            }
        }
        throw new ServiceException("datail not found not found",404);
    }

    public ApplicationResponce addDetail(WheelPoh detail) throws ServiceException {
        WheelPoh wheelPoh = repository.save(detail);
        if(wheelPoh!=null){
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("save Successfully");
            return applicationResponce;
        }
        throw new ServiceException("not save succsfully",500);
    }

    public ApplicationResponce updateDetail(Long id, WheelPoh detail) throws ServiceException {
        WheelPoh existing = repository.findById(id)
                .orElseThrow(() -> new ServiceException("Wheel POH not found",404));

        existing.setDate(detail.getDate());
        existing.setWheelNo(detail.getWheelNo());
        existing.setWheelType(detail.getWheelType());
        existing.setTreadDia(detail.getTreadDia());
        existing.setFlange(detail.getFlange());
        existing.setJournalDiaA(detail.getJournalDiaA());
        existing.setSnpdBearingA(detail.getSnpdBearingA());
        existing.setBearingMake(detail.getBearingMake());
        existing.setShrinkingA(detail.getShrinkingA());
        existing.setJournalDiaB(detail.getJournalDiaB());
        existing.setSnpdBearingB(detail.getSnpdBearingB());
        existing.setShrinkingB(detail.getShrinkingB());
        existing.setUst(detail.getUst());
        existing.setBearing(detail.getBearing()); // New field

        WheelPoh wheelPoh= repository.save(existing);
        if(wheelPoh!=null){
            ApplicationResponce applicationResponce=   new ApplicationResponce();
            applicationResponce.setData("save successfully");
            return applicationResponce;
        }
        throw new ServiceException("not save successfully",500);
    }

    public ApplicationResponce deleteDetail(Long id) throws ServiceException {
        Optional<WheelPoh> detail = repository.findById(id);
        if(detail.isPresent()){
            repository.delete(detail.get());
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setData("delete successfully");
            return applicationResponce;
        }
        throw new ServiceException("detail not found",404);
    }

    public Page<WheelPoh> getPaginatedData(String search, Pageable pageable) {
        return repository.searchByPlantNnoNative(search, pageable);
    }
}
