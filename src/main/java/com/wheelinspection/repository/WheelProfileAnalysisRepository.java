package com.wheelinspection.repository;

import com.wheelinspection.entity.WheelProfileAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelProfileAnalysisRepository extends JpaRepository<WheelProfileAnalysis, Long> {
}
