package com.wheelinspection.repository;

import com.wheelinspection.entity.PreInspectionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreInspectionRecordRepository extends JpaRepository<PreInspectionRecord, Long> {
}
