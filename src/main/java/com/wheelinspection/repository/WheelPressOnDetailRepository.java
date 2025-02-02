package com.wheelinspection.repository;

import com.wheelinspection.entity.WheelPoh;
import com.wheelinspection.entity.WheelPressOnDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelPressOnDetailRepository extends JpaRepository<WheelPressOnDetail, Long> {

    @Query(value = "SELECT * FROM wheel_press_on_detail WHERE id LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<WheelPressOnDetail> searchByPlantNnoNative(@Param("search") String search, Pageable pageable);




}
