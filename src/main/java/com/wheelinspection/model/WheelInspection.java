package com.wheelinspection.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wheel_inspection")
public class WheelInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String wheelNumber;
    private String inspectionStatus;
    private Date dateOfInspection;

    // Constructors, Getters, and Setters
}
