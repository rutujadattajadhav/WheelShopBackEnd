package com.wheelinspection.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wheel_press_on_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WheelPressOnDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "WHEEL SET NO. NEW")
    private String wheelSetNoNew;

    @Column(name = "DATE")
    private String date;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "WHEEL DISC  BORE A")
    private Double wheelDiscBoreA;

    @Column(name = "AXLE WHEEL  SET BORE A")
    private Double axleWheelSetBoreA;

    @Column(name = "WHEEL DISC  BORE B")
    private Double wheelDiscBoreB;

    @Column(name = "AXLE WHEEL  SET BORE B")
    private Double axleWheelSetBoreB;

    @Column(name = "INTERFERANCE A")
    private Double interferenceA;

    @Column(name = "INTERFERANCE B")
    private Double interferenceB;

    @Column(name = "WHEEL PRESS PRESSURE A")
    private String wheelPressPressureA;

    @Column(name = "WHEEL PRESS PRESSURE B")
    private String wheelPressPressureB;

    @Column(name = "DISC SERIAL NO. A")
    private String discSerialNoA;

    @Column(name = "DISC SERIAL NO. B")
    private String discSerialNoB;

    @Column(name = "AXLE PERTICULAR")
    private String axleParticular;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "REMARK")
    private String remark;
}
