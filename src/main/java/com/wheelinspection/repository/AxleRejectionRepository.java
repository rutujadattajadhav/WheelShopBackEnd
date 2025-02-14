package com.wheelinspection.repository;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.entity.BreakdownHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AxleRejectionRepository extends JpaRepository<AxleRejection, Long> {

    @Query(value = "SELECT * FROM axle_rejection WHERE axle_no LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<AxleRejection> searchByVehicleNative(@Param("search") String search, Pageable pageable);


    //Page<AxleRejection> findAll(Pageable pageable);



}
