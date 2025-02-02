package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wheel_profile_anyalysis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WheelProfileAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NEW SHOP SR NO")
    private String newShopSrNo;

    @Column(name = "IN COMING WHEEL SIZE")
    private String incomingWheelSize;

    @Column(name = "FINAL DIA")
    private Integer finalDia;

    @Column(name = "DIFF")
    private Integer diff;

    @Column(name = "DEPTH OF CUT")
    private Double depthOfCut;
}
