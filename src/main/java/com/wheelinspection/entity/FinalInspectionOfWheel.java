package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "final_inspetion_of_wheel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalInspectionOfWheel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "WHEEL NO.")
    private String wheelNo;

    @Column(name = "DATE OF RB FITTING")
    private String dateOfRbFitting;

    @Column(name = "WHEEL TYPE")
    private String wheelType;

    @Column(name = "Axle No.")
    private String axleNo;

    @Column(name = "Wheel Disc particular  A")
    private String wheelDiscParticularA;

    @Column(name = "Wheel Disc particular  B")
    private String wheelDiscParticularB;

    @Column(name = "Axle box A side")
    private String axleBoxASide;

    @Column(name = "Axle Box BORE A")
    private Double axleBoxBoreA;

    @Column(name = "Axle box B side")
    private String axleBoxBSide;

    @Column(name = "Axle Box BORE B")
    private Double axleBoxBoreB;

    @Column(name = "Tread Dia")
    private Integer treadDia;

    @Column(name = "Fange SIZE")
    private Double flangeSize;

    @Column(name = "Rod Gauge")
    private Integer rodGauge;

    @Column(name = "Journal Dia A")
    private Double journalDiaA;

    @Column(name = "Journal Dia B")
    private Double journalDiaB;

    @Column(name = "SNPD_Bearing_No A")
    private String snpdBearingNoA;

    @Column(name = "SNPD_Bearing_No B")
    private String snpdBearingNoB;

    @Column(name = "Bearing INITIAL NO A")
    private String bearingInitialNoA;

    @Column(name = "YEAR")
    private String yearA;

    @Column(name = "Bearing INITIAL NO B")
    private String bearingInitialNoB;

    @Column(name = "YEAR B")
    private String yearB;

    @Column(name = "Bearing Make A")
    private String bearingMakeA;

    @Column(name = "Bearing Make B")
    private String bearingMakeB;

    @Column(name = "Bearing bore A")
    private Double bearingBoreA;

    @Column(name = "Bearing bore B")
    private Double bearingBoreB;

    @Column(name = "R/C A")
    private Double rcA;

    @Column(name = "R/C B")
    private Double rcB;

    @Column(name = "R/CA M")
    private Double rcaM;

    @Column(name = "R/CB M")
    private Double rcbM;

    @Column(name = "SHRINKING ALLOWANCE A")
    private Double shrinkingAllowanceA;

    @Column(name = "SHRINKING ALLOWANCE B")
    private Double shrinkingAllowanceB;

    @Column(name = "LIFE OF BEARING A")
    private Integer lifeOfBearingA;

    @Column(name = "LIFE OF BEARING B")
    private Integer lifeOfBearingB;

    @Column(name = "BEARING INSPECTION")
    private String bearingInspection;

    @Column(name = "SHRINKING")
    private String shrinking;

    @Column(name = "FITTING")
    private String fitting;

    @Column(name = "M-16/M-20")
    private String m16M20;

    @Column(name = "UST")
    private String ust;

    @Column(name = "COACH NO")
    private String coachNo;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "MyUnknownColumn")
    private String unknownColumn;
}
