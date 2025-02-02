package com.wheelinspection.repository;

import com.wheelinspection.entity.Rard;
import com.wheelinspection.entity.Sheet22;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Sheet22Repository extends JpaRepository<Sheet22, Long> {

    @Query(value = "SELECT * FROM sheet22 WHERE id LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Page<Sheet22> searchByPlantNnoNative(@Param("search") String search, Pageable pageable);


}
