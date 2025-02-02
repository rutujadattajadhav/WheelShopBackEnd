package com.wheelinspection.repository;

import com.wheelinspection.entity.PreInspectionRecord;
import com.wheelinspection.entity.Rard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RardRepository extends JpaRepository<Rard, Long> {

    @Query(value = "SELECT * FROM rard WHERE id LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<Rard> searchByPlantNnoNative(@Param("search") String search, Pageable pageable);


}
