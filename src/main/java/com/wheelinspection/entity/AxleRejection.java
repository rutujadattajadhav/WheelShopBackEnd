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

    @Column(name = " Axle no")
    private String axleNo;

    @Column(name = "Year of Mfg")
    private Integer yearOfMfg;

    @Column(name = "Reason of Rejection Axle ")
    private String reasonOfRejectionAxle;
}
