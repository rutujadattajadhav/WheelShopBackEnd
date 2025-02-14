package com.wheelinspection.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bearing_rejection_data")
public class BearingRejectionData {

    @Id
    @Column(name = "bearing_no", length = 50, nullable = false)
    private String bearingNo;

    @Column(name = "rejection_reason", columnDefinition = "TEXT")
    private String rejectionReason;

    @Column(name = "rejection_date")
    @Temporal(TemporalType.DATE)
    private Date rejectionDate;

    @Column(name = "inspector", length = 100)
    private String inspector;

    @Column(name = "bearing_make", length = 100)
    private String bearingMake;

    @Column(name = "bearing_type", length = 50)
    private String bearingType;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "count", length = 255)
    private String count;

    @Column(name = "date", length = 255)
    private String date;

    @Column(name = "life_in_month")
    private Integer lifeInMonth;

    @Column(name = "life_in__year")
    private Integer lifeInYear;

    @Column(name = "make", length = 255)
    private String make;

    @Column(name = "mfg_no", length = 255)
    private String mfgNo;

    @Column(name = "month", length = 255)
    private String month;

    @Column(name = "reason_for_rejection", length = 255)
    private String reasonForRejection;

    @Column(name = "rejection_percentage", length = 255)
    private String rejectionPercentage;

    @Column(name = "total__inspected", length = 255)
    private String totalInspected;

    // Getters and Setters

    public String getBearingNo() {
        return bearingNo;
    }

    public void setBearingNo(String bearingNo) {
        this.bearingNo = bearingNo;
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

    public String getBearingMake() {
        return bearingMake;
    }

    public void setBearingMake(String bearingMake) {
        this.bearingMake = bearingMake;
    }

    public String getBearingType() {
        return bearingType;
    }

    public void setBearingType(String bearingType) {
        this.bearingType = bearingType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getLifeInMonth() {
        return lifeInMonth;
    }

    public void setLifeInMonth(Integer lifeInMonth) {
        this.lifeInMonth = lifeInMonth;
    }

    public Integer getLifeInYear() {
        return lifeInYear;
    }

    public void setLifeInYear(Integer lifeInYear) {
        this.lifeInYear = lifeInYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMfgNo() {
        return mfgNo;
    }

    public void setMfgNo(String mfgNo) {
        this.mfgNo = mfgNo;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }

    public String getRejectionPercentage() {
        return rejectionPercentage;
    }

    public void setRejectionPercentage(String rejectionPercentage) {
        this.rejectionPercentage = rejectionPercentage;
    }

    public String getTotalInspected() {
        return totalInspected;
    }

    public void setTotalInspected(String totalInspected) {
        this.totalInspected = totalInspected;
    }
}
