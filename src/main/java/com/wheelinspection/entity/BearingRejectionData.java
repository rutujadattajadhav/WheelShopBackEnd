package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bearing_rejection_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BearingRejectionData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Date")
    private String date;

    @Column(name = "MONTH")
    private String month;

    @Column(name = "bearing_type")
    private String bearingType;

    @Column(name = "mfg_no")
    private String mfgNo;

    @Column(name = "MAKE")
    private String make;

    @Column(name = "life_in_month")
    private Integer lifeInMonth;

    @Column(name = "life_in__year")
    private Integer lifeInYear;

    @Column(name = "reason_for_rejection")
    private String reasonForRejection;

    @Column(name = "total__inspected")
    private String totalInspected;

    @Column(name = "rejection_percentage")
    private String rejectionPercentage;

    @Column(name = "COUNT")
    private String count;
}
