package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wheel_poh_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WheelPoh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false, name = "wheel_no")
    private String wheelNo;

    @Column(nullable = false, name = "wheel_type")
    private String wheelType;

    @Column(nullable = false, name = "tread_dia")
    private Integer treadDia;

    @Column(nullable = false, name = "flange")
    private Double flange;

    @Column(nullable = false, name = "journal_dia_a")
    private Double journalDiaA;

    @Column(nullable = false, name = "snpd_bearing_a")
    private String snpdBearingA;

    @Column(nullable = false, name = "bearing_make")
    private String bearingMake;

    @Column(nullable = false, name = "shrinking_a")
    private Double shrinkingA;

    @Column(nullable = false, name = "journal_dia_b")
    private Double journalDiaB;

    @Column(nullable = false, name = "snpd_bearing_b")
    private String snpdBearingB;

    @Column(nullable = false, name = "shrinking_b")
    private Double shrinkingB;

    @Column(nullable = false)
    private String ust;

    // New Column
    @Column(nullable = false)
    private String bearing;
}
