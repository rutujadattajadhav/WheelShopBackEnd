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

    @Column(name = "BEARING TYPE")
    private String bearingType;

    @Column(name = "MFG NO")
    private String mfgNo;

    @Column(name = "MAKE")
    private String make;

    @Column(name = "LIFE IN MONTH")
    private Integer lifeInMonth;

    @Column(name = "LIFE IN  YEAR")
    private Integer lifeInYear;

    @Column(name = "REASON FOR REJECTION")
    private String reasonForRejection;

    @Column(name = "TOTAL  INSPECTED")
    private String totalInspected;

    @Column(name = "Rejection percentage")
    private String rejectionPercentage;

    @Column(name = "COUNT")
    private String count;
}
