package com.wheelinspection.service;

import com.wheelinspection.entity.WheelPoh;
import com.wheelinspection.repository.WheelPohRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WheelPohService {

    @Autowired
    private WheelPohRepository repository;

    public List<WheelPoh> getAllDetails() {
        return repository.findAll();
    }

    public WheelPoh getDetailById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wheel POH not found"));
    }

    public WheelPoh addDetail(WheelPoh detail) {
        return repository.save(detail);
    }

    public WheelPoh updateDetail(Long id, WheelPoh detail) {
        WheelPoh existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wheel POH not found"));

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

        return repository.save(existing);
    }

    public String deleteDetail(Long id) {
        WheelPoh detail = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wheel POH not found"));
        repository.delete(detail);
        return "Delete successfully";
    }
}
