package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "demu_bearing_rejection_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemuBearingRejectionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Date")
    private String date;

    @Column(name = "MONTH")
    private String month;

    @Column(name = "MFG NO")
    private String mfgNo;

    @Column(name = "MAKE")
    private String make;

    @Column(name = "LIFE IN MONTH")
    private Integer lifeInMonth;

    @Column(name = "LIFE IN  YEAR")
    private Double lifeInYear;

    @Column(name = "REASON FOR REJECTION")
    private String reasonForRejection;

    @Column(name = "TOTAL  INSPECTED")
    private String totalInspected;

    @Column(name = "Rejection percentage")
    private String rejectionPercentage;

    @Column(name = "COUNT")
    private String count;

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

    @Column(name = "MyUnknownColumn_[15]")
    private String myUnknownColumn15;

    @Column(name = "MyUnknownColumn_[16]")
    private String myUnknownColumn16;

    @Column(name = "MyUnknownColumn_[17]")
    private String myUnknownColumn17;
}
