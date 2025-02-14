package com.wheelinspection.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "axle_rejection")
public class AxleRejection {

    @Id
    @Column(name = "axle_no", length = 50, nullable = false)
    private String axleNo;

    @Column(name = "rejection_reason", columnDefinition = "TEXT")
    private String rejectionReason;

    @Column(name = "rejection_date")
    @Temporal(TemporalType.DATE)
    private Date rejectionDate;

    @Column(name = "inspector", length = 100)
    private String inspector;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "reason_of_rejection_axle", length = 255)
    private String reasonOfRejectionAxle;

    @Column(name = "year_of_mfg")
    private Integer yearOfMfg;

    // Getters and Setters

    public String getAxleNo() {
        return axleNo;
    }

    public void setAxleNo(String axleNo) {
        this.axleNo = axleNo;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public Date getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(Date rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReasonOfRejectionAxle() {
        return reasonOfRejectionAxle;
    }

    public void setReasonOfRejectionAxle(String reasonOfRejectionAxle) {
        this.reasonOfRejectionAxle = reasonOfRejectionAxle;
    }

    public Integer getYearOfMfg() {
        return yearOfMfg;
    }

    public void setYearOfMfg(Integer yearOfMfg) {
        this.yearOfMfg = yearOfMfg;
    }
}
