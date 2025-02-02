package com.wheelinspection.repository;

import com.wheelinspection.entity.WheelPressOnDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelPressOnDetailRepository extends JpaRepository<WheelPressOnDetail, Long> {}
