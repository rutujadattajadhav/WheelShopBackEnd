package com.wheelinspection.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "wheel_inspection")
public class WheelInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_recorded")
    @Temporal(TemporalType.DATE)
    private Date dateRecorded;

    @Column(name = "recd_from", length = 255)
    private String recdFrom;

    @Column(name = "shop_sr_no", length = 50)
    private String shopSrNo;

    @Column(name = "new_shop_sr_no", length = 50)
    private String newShopSrNo;

    @Column(name = "type_of_wheel", length = 100)
    private String typeOfWheel;

    @Column(name = "tag_no", length = 50)
    private String tagNo;

    @Column(name = "coach", length = 50)
    private String coach;

    @Column(name = "wheel_type", length = 50)
    private String wheelType;

    @Column(name = "wheel_dia_a", precision = 10, scale = 2)
    private BigDecimal wheelDiaA;

    @Column(name = "wheel_dia_b", precision = 10, scale = 2)
    private BigDecimal wheelDiaB;

    @Column(name = "flange", precision = 10, scale = 2)
    private BigDecimal flange;

    @Column(name = "rod_gauge", precision = 10, scale = 2)
    private BigDecimal rodGauge;

    @Column(name = "wheel_disc_particular_a", columnDefinition = "TEXT")
    private String wheelDiscParticularA;

    @Column(name = "wheel_disc_particular_b", columnDefinition = "TEXT")
    private String wheelDiscParticularB;

    @Column(name = "sound_test", length = 50)
    private String soundTest;

    @Column(name = "repair_of_types", length = 255)
    private String repairOfTypes;

    @Column(name = "gear", length = 50)
    private String gear;

    @Column(name = "msu", length = 50)
    private String msu;

    @Column(name = "wheel_defacts_cmi_k003", columnDefinition = "TEXT")
    private String wheelDefactsCmiK003;

    @Column(name = "remark", columnDefinition = "TEXT")
    private String remark;

    @Column(name = "inspector_name", length = 255)
    private String inspectorName;

    @Column(name = "date_of_inspection")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfInspection;

    @Column(name = "inspection_status", length = 255)
    private String inspectionStatus;

    @Column(name = "wheel_number", length = 255)
    private String wheelNumber;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(Date dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public String getRecdFrom() {
        return recdFrom;
    }

    public void setRecdFrom(String recdFrom) {
        this.recdFrom = recdFrom;
    }

    public String getShopSrNo() {
        return shopSrNo;
    }

    public void setShopSrNo(String shopSrNo) {
        this.shopSrNo = shopSrNo;
    }

    public String getNewShopSrNo() {
        return newShopSrNo;
    }

    public void setNewShopSrNo(String newShopSrNo) {
        this.newShopSrNo = newShopSrNo;
    }

    public String getTypeOfWheel() {
        return typeOfWheel;
    }

    public void setTypeOfWheel(String typeOfWheel) {
        this.typeOfWheel = typeOfWheel;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getWheelType() {
        return wheelType;
    }

    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }

    public BigDecimal getWheelDiaA() {
        return wheelDiaA;
    }

    public void setWheelDiaA(BigDecimal wheelDiaA) {
        this.wheelDiaA = wheelDiaA;
    }

    public BigDecimal getWheelDiaB() {
        return wheelDiaB;
    }

    public void setWheelDiaB(BigDecimal wheelDiaB) {
        this.wheelDiaB = wheelDiaB;
    }

    public BigDecimal getFlange() {
        return flange;
    }

    public void setFlange(BigDecimal flange) {
        this.flange = flange;
    }

    public BigDecimal getRodGauge() {
        return rodGauge;
    }

    public void setRodGauge(BigDecimal rodGauge) {
        this.rodGauge = rodGauge;
    }

    public String getWheelDiscParticularA() {
        return wheelDiscParticularA;
    }

    public void setWheelDiscParticularA(String wheelDiscParticularA) {
        this.wheelDiscParticularA = wheelDiscParticularA;
    }

    public String getWheelDiscParticularB() {
        return wheelDiscParticularB;
    }

    public void setWheelDiscParticularB(String wheelDiscParticularB) {
        this.wheelDiscParticularB = wheelDiscParticularB;
    }

    public String getSoundTest() {
        return soundTest;
    }

    public void setSoundTest(String soundTest) {
        this.soundTest = soundTest;
    }

    public String getRepairOfTypes() {
        return repairOfTypes;
    }

    public void setRepairOfTypes(String repairOfTypes) {
        this.repairOfTypes = repairOfTypes;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getMsu() {
        return msu;
    }

    public void setMsu(String msu) {
        this.msu = msu;
    }

    public String getWheelDefactsCmiK003() {
        return wheelDefactsCmiK003;
    }

    public void setWheelDefactsCmiK003(String wheelDefactsCmiK003) {
        this.wheelDefactsCmiK003 = wheelDefactsCmiK003;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public Date getDateOfInspection() {
        return dateOfInspection;
    }

    public void setDateOfInspection(Date dateOfInspection) {
        this.dateOfInspection = dateOfInspection;
    }

    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public String getWheelNumber() {
        return wheelNumber;
    }

    public void setWheelNumber(String wheelNumber) {
        this.wheelNumber = wheelNumber;
    }
}
