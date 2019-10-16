package com.attendance.bean;

public class VacationBean {
    private String V_NO;
    private String V_NAME;
    private String V_SDATE;
    private String V_START;
    private String V_EDATE;
    private String V_END;
    private String V_TOTAL;
    private String V_CONDITION;
    private String V_REASON;

    @Override
    public String toString() {
        return "VacationBean{" +
                "V_NO='" + V_NO + '\'' +
                ", V_NAME='" + V_NAME + '\'' +
                ", V_SDATE='" + V_SDATE + '\'' +
                ", V_START='" + V_START + '\'' +
                ", V_EDATE='" + V_EDATE + '\'' +
                ", V_END='" + V_END + '\'' +
                ", V_TOTAL='" + V_TOTAL + '\'' +
                ", V_CONDITION='" + V_CONDITION + '\'' +
                ", V_REASON='" + V_REASON + '\'' +
                '}';
    }

    public String getV_NO() {
        return V_NO;
    }

    public void setV_NO(String v_NO) {
        V_NO = v_NO;
    }

    public String getV_NAME() {
        return V_NAME;
    }

    public void setV_NAME(String v_NAME) {
        V_NAME = v_NAME;
    }

    public String getV_SDATE() {
        return V_SDATE;
    }

    public void setV_SDATE(String v_SDATE) {
        V_SDATE = v_SDATE;
    }

    public String getV_START() {
        return V_START;
    }

    public void setV_START(String v_START) {
        V_START = v_START;
    }

    public String getV_EDATE() {
        return V_EDATE;
    }

    public void setV_EDATE(String v_EDATE) {
        V_EDATE = v_EDATE;
    }

    public String getV_END() {
        return V_END;
    }

    public void setV_END(String v_END) {
        V_END = v_END;
    }

    public String getV_TOTAL() {
        return V_TOTAL;
    }

    public void setV_TOTAL(String v_TOTAL) {
        V_TOTAL = v_TOTAL;
    }

    public String getV_CONDITION() {
        return V_CONDITION;
    }

    public void setV_CONDITION(String v_CONDITION) {
        V_CONDITION = v_CONDITION;
    }

    public String getV_REASON() {
        return V_REASON;
    }

    public void setV_REASON(String v_REASON) {
        V_REASON = v_REASON;
    }

    public VacationBean(String v_NO, String v_NAME, String v_SDATE, String v_START, String v_EDATE, String v_END, String v_TOTAL, String v_CONDITION, String v_REASON) {
        V_NO = v_NO;
        V_NAME = v_NAME;
        V_SDATE = v_SDATE;
        V_START = v_START;
        V_EDATE = v_EDATE;
        V_END = v_END;
        V_TOTAL = v_TOTAL;
        V_CONDITION = v_CONDITION;
        V_REASON = v_REASON;
    }
}
