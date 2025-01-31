package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "machines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Primary Key Column
    private Long id;

    @Column(name = "plant_no", nullable = false)
    private Integer plantNo;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "acquisition_date", nullable = false)
    private String acquisitionDate;

    @Column(name = "capacity", nullable = false)
    private String capacity;
}
