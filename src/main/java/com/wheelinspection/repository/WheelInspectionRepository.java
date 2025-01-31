package com.wheelinspection.repository;

import com.wheelinspection.model.WheelInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WheelInspectionRepository extends JpaRepository<WheelInspection, Long> {
}
