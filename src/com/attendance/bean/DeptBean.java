package com.attendance.bean;

public class DeptBean {
    private String D_NO;
    private String D_NAME;
    private String D_CHARGE;
    private String D_LIMIT;
    private String D_REGISTIME;

    @Override
    public String toString() {
        return "DeptBean{" +
                "D_NO='" + D_NO + '\'' +
                ", D_NAME='" + D_NAME + '\'' +
                ", D_CHARGE='" + D_CHARGE + '\'' +
                ", D_LIMIT='" + D_LIMIT + '\'' +
                ", D_REGISTIME='" + D_REGISTIME + '\'' +
                '}';
    }

    public String getD_NO() {
        return D_NO;
    }

    public void setD_NO(String d_NO) {
        D_NO = d_NO;
    }

    public String getD_NAME() {
        return D_NAME;
    }

    public void setD_NAME(String d_NAME) {
        D_NAME = d_NAME;
    }

    public String getD_CHARGE() {
        return D_CHARGE;
    }

    public void setD_CHARGE(String d_CHARGE) {
        D_CHARGE = d_CHARGE;
    }

    public String getD_LIMIT() {
        return D_LIMIT;
    }

    public void setD_LIMIT(String d_LIMIT) {
        D_LIMIT = d_LIMIT;
    }

    public String getD_REGISTIME() {
        return D_REGISTIME;
    }

    public void setD_REGISTIME(String d_REGISTIME) {
        D_REGISTIME = d_REGISTIME;
    }

    public DeptBean(String d_NO, String d_NAME, String d_CHARGE, String d_LIMIT, String d_REGISTIME) {
        D_NO = d_NO;
        D_NAME = d_NAME;
        D_CHARGE = d_CHARGE;
        D_LIMIT = d_LIMIT;
        D_REGISTIME = d_REGISTIME;
    }
}
