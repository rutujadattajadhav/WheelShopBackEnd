package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "axle_rejection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AxleRejection {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "axle_no")
    private String axleNo;

    @Column(name = "year_of_mfg")
    private Integer yearOfMfg;

    @Column(name = "reason_of_rejection_axle")
    private String reasonOfRejectionAxle;
}
