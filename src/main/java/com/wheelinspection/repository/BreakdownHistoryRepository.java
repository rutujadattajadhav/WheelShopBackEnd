package com.wheelinspection.repository;

import com.wheelinspection.entity.BreakdownHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakdownHistoryRepository extends JpaRepository<BreakdownHistory, Long> {



    @Query(value = "SELECT * FROM breakdown_history WHERE serial_number LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<BreakdownHistory> searchByVehicleNative(@Param("search") String search, Pageable pageable);

    Page<BreakdownHistory> findAll(Pageable pageable);

}
