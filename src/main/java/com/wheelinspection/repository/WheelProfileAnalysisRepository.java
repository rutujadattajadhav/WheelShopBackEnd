package com.wheelinspection.repository;

import com.wheelinspection.entity.WheelPressOnDetail;
import com.wheelinspection.entity.WheelProfileAnalysis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelProfileAnalysisRepository extends JpaRepository<WheelProfileAnalysis, Long> {

    @Query(value = "SELECT * FROM wheel_profile_anyalysis WHERE id LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<WheelProfileAnalysis> searchByPlantNnoNative(@Param("search") String search, Pageable pageable);


}
