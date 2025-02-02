package com.wheelinspection.repository;

import com.wheelinspection.entity.AxleRejection;
import com.wheelinspection.entity.BearingRejectionData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BearingRejectionDataRepository extends JpaRepository<BearingRejectionData, Long> {

    @Query(value = "SELECT * FROM bearing_rejection_data WHERE id LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<BearingRejectionData> searchByVehicleNative(@Param("search") String search, Pageable pageable);


}
