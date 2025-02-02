package com.wheelinspection.repository;

import com.wheelinspection.entity.FinalInspectionOfWheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalInspectionOfWheelRepository extends JpaRepository<FinalInspectionOfWheel, Long> {
}
