package com.wheelinspection.repository;

import com.wheelinspection.entity.Sheet22;
import com.wheelinspection.entity.WheelPoh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WheelPohRepository extends JpaRepository<WheelPoh, Long> {

    @Query(value = "SELECT * FROM wheel_poh_details WHERE id LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<WheelPoh> searchByPlantNnoNative(@Param("search") String search, Pageable pageable);


}
