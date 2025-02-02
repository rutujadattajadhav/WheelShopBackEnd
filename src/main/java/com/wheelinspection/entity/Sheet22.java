package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sheet22")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sheet22 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "01.10.2024")
    private String date_01_10_2024;

    @Column(name = "SNPD POH")
    private String snpdPoh;

    @Column(name = "U-16243")
    private String u16243;

    @Column(name = "MyUnknownColumn")
    private String myUnknownColumn;

    @Column(name = "HCC/TRL (CAST)")
    private String hccTrlCast;

    @Column(name = "28-23")
    private String batchNo;

    @Column(name = "5339")
    private String serialNo;

    @Column(name = "A")
    private String side;

    @Column(name = "877")
    private Integer value877;

    @Column(name = "883")
    private Integer value883;

    @Column(name = "26")
    private Integer value26;

    @Column(name = "6")
    private Integer value6;

    @Column(name = "1")
    private String column1;

    @Column(name = "2")
    private String column2;

    @Column(name = "3")
    private String column3;

    @Column(name = "MyUnknownColumn_[0]")
    private String myUnknownColumn0;

    @Column(name = "4")
    private String column4;

    @Column(name = "5")
    private String column5;

    @Column(name = "MyUnknownColumn_[1]")
    private String myUnknownColumn1;

    @Column(name = "6_[0]")
    private String column6_0;

    @Column(name = "7")
    private String column7;

    @Column(name = "8")
    private String column8;

    @Column(name = "9")
    private String column9;

    @Column(name = "10")
    private String column10;

    @Column(name = "11")
    private String column11;
}
