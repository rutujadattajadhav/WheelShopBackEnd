package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "YEAR")
    private String year;

    @Column(name = "TOTAL WHEEL")
    private Integer totalWheel;

    @Column(name = "RD")
    private Integer rd;

    @Column(name = "PERCENTAGE")
    private Double percentage;

    @Column(name = "RA")
    private Integer ra;

    @Column(name = "PERCENTAGE_[0]")
    private Double percentageRa;

    @Column(name = "RA/RD")
    private Integer raRd;

    @Column(name = "PERCENTAGE_[1]")
    private Double percentageRaRd;

    @Column(name = "TOTAL")
    private Integer total;

    @Column(name = "PERCENTAGE_[2]")
    private Double percentageTotal;

    // Unknown columns
    @Column(name = "MyUnknownColumn")
    private String myUnknownColumn;

    @Column(name = "MyUnknownColumn_[0]")
    private String myUnknownColumn0;

    @Column(name = "MyUnknownColumn_[1]")
    private String myUnknownColumn1;

    @Column(name = "MyUnknownColumn_[2]")
    private String myUnknownColumn2;

    @Column(name = "MyUnknownColumn_[3]")
    private String myUnknownColumn3;

    @Column(name = "MyUnknownColumn_[4]")
    private String myUnknownColumn4;

    @Column(name = "MyUnknownColumn_[5]")
    private String myUnknownColumn5;

    @Column(name = "MyUnknownColumn_[6]")
    private String myUnknownColumn6;

    @Column(name = "MyUnknownColumn_[7]")
    private String myUnknownColumn7;

    @Column(name = "MyUnknownColumn_[8]")
    private String myUnknownColumn8;

    @Column(name = "MyUnknownColumn_[9]")
    private String myUnknownColumn9;

    @Column(name = "MyUnknownColumn_[10]")
    private String myUnknownColumn10;

    @Column(name = "MyUnknownColumn_[11]")
    private String myUnknownColumn11;

    @Column(name = "MyUnknownColumn_[12]")
    private String myUnknownColumn12;

    @Column(name = "MyUnknownColumn_[13]")
    private String myUnknownColumn13;

    @Column(name = "MyUnknownColumn_[14]")
    private String myUnknownColumn14;
}
