package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pre_inspection_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreInspectionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DATE")
    private String date;
    
    @Column(name = "RECD FROM")
    private String receivedFrom;

    @Column(name = "shop.sr.No ")
    private String shopSrNo;

    @Column(name = "NEW SHOP SR NO")
    private String newShopSrNo;

    @Column(name = "Type of Wheel")
    private String typeOfWheel;

    @Column(name = "Tag No")
    private String tagNo;

    @Column(name="Coach")
    private String coach;

    @Column(name="TYPE")
    private String wheelType;
    
    @Column(name = "WHEEL DIA A")
    private String wheelDiaA;

    @Column(name = "WHEEL DIA B")
    private String wheelDiaB;


   @Column(name = "Rod Gauge")
    private Double rodGauge;


    @Column(name = "Wheel Disc particular A")
    private String wheelDiscParticularA;

    @Column(name = "Wheel Disc particular B")
    private String wheelDiscParticularB;

    @Column(name = "Sound Test")
    private String soundTest;

    @Column(name = "Repair of Types")
    private String repairOfTypes;

    @Column(name="GEAR")
    private String gear;

    @Column(name = "MSU")
    private String msu;

    @Column(name = "Wheel Defacts as per cmi-k003")
    private String wheelDefectsCmiK003;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "Inspector_Name")
    private String inspectorName;

    @Column(name = "MyUnknownColumn")
    private String unknownCol1;

    @Column(name = "MyUnknownColumn_[0]")
    private String unknownCol2;

    @Column(name = "MyUnknownColumn_[1]")
    private String unknownCol3;

    @Column(name = "MyUnknownColumn_[2]")
    private String unknownCol4;

    @Column(name = "MyUnknownColumn_[3]")
    private String unknownCol5;

    @Column(name = "MyUnknownColumn_[4]")
    private String unknownCol6;
}

