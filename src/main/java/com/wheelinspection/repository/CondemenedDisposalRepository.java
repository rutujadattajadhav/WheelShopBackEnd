package com.wheelinspection.repository;

import com.wheelinspection.entity.BearingRejectionData;
import com.wheelinspection.entity.CondemenedDisposal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CondemenedDisposalRepository extends JpaRepository<CondemenedDisposal, Long> {

    @Query(value = "SELECT * FROM condemened_disposal WHERE id LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<CondemenedDisposal> searchByVehicleNative(@Param("search") String search, Pageable pageable);



}
