package com.wheelinspection.error;

public class WheelInspectionError {

   private String  errormsg;
   private String errcode;

    public WheelInspectionError(String errormsg, String errcode) {
        this.errormsg = errormsg;
        this.errcode = errcode;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
}
