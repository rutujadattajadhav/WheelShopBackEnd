package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "condemened_disposal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CondemenedDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SR. NO.")
    private Integer srNo;

    @Column(name = "Date")
    private String date;

    @Column(name = "DS-8/G27")
    private Integer ds8G27;

    @Column(name = "PL.NO")
    private Integer plNo;

    @Column(name = "Description")
    private String description;

    @Column(name = "Qty")
    private String qty;

    @Column(name = "Qty in weight")
    private String qtyInWeight;

    @Column(name = "Depot")
    private String depot;

    @Column(name = "MyUnknownColumn")
    private String myUnknownColumn;
}
