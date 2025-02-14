package com.wheelinspection.repository;

import com.wheelinspection.entity.CondemenedDisposal;
import com.wheelinspection.entity.DemuBearingRejectionData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DemuBearingRejectionDataRepository extends JpaRepository<DemuBearingRejectionData, Long> {


    @Query(value = "SELECT * FROM demu_bearing_rejection_data WHERE date LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<DemuBearingRejectionData> searchByVehicleNative(@Param("search") String search, Pageable pageable);


}
