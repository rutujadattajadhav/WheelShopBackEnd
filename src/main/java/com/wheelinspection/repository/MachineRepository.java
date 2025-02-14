package com.wheelinspection.repository;

import com.wheelinspection.entity.BreakdownHistory;
import com.wheelinspection.entity.Machine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MachineRepository extends JpaRepository<Machine, Long> {


    @Query(value = "SELECT * FROM machines WHERE id LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<Machine> searchByPlantNnoNative(@Param("search") String search, Pageable pageable);

    Page<Machine> findAll(Pageable pageable);


}
