package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "demu_bearing_rejection_data")
@Data
public class DemuBearingRejectionData {

    @Id
    @Column(name = "date", length = 255, nullable = false)
    private String date;

    @Column(name = "month_", columnDefinition = "TEXT")
    private String monthData;

    @Column(name = "mfg_no", length = 50)
    private String mfgNo;

    @Column(name = "make", length = 255)
    private String make;

    @Column(name = "life_in_month_", columnDefinition = "TEXT")
    private String lifeInMonthData;

    @Column(name = "life_in_year_", columnDefinition = "TEXT")
    private String lifeInYearData;

    @Column(name = "reason_for_rejection", columnDefinition = "TEXT")
    private String reasonForRejection;

    @Column(name = "total_inspected", columnDefinition = "TEXT")
    private String totalInspected;

    @Column(name = "rejection_percentage_", columnDefinition = "TEXT")
    private String rejectionPercentage;

    @Column(name = "count", length = 255)
    private String count;

    @Column(name = "life_in_month")
    private Integer lifeInMonth;

    @Column(name = "life_in_year")
    private Double lifeInYear;

    @Column(name = "mfg_no_alt", length = 255)
    private String mfgNoAlt;

    @Column(name = "month_alt", length = 255)
    private String monthAlt;

    @Column(name = "reason_for_rejection_alt", length = 255)
    private String reasonForRejectionAlt;

    @Column(name = "rejection_percentage_alt", length = 255)
    private String rejectionPercentageAlt;

    @Column(name = "total_inspected_alt", length = 255)
    private String totalInspectedAlt;
}
