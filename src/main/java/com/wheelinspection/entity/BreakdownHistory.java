package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "breakdown_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BreakdownHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name = "plant_name")
    private String plantName;

    @Column(name = "issue")
    private String issue;

    @Column(name = "no_of_days")
    private Integer noOfDays;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    // Getters and Setters
}

