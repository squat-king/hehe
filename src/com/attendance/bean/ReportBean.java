package com.attendance.bean;

public class ReportBean {
    private String R_NO;
    private String R_NAME;
    private String R_TIME;
    private String R_PROGRESS;
    private String R_CONTENT;
    private String R_KEYPOINT;
    private String R_CONTRACT;

    @java.lang.Override
    public java.lang.String toString() {
        return "ReportBean{" +
                "R_NO='" + R_NO + '\'' +
                ", R_NAME='" + R_NAME + '\'' +
                ", R_TIME='" + R_TIME + '\'' +
                ", R_PROGRESS='" + R_PROGRESS + '\'' +
                ", R_CONTENT='" + R_CONTENT + '\'' +
                ", R_KEYPOINT='" + R_KEYPOINT + '\'' +
                ", R_CONTRACT='" + R_CONTRACT + '\'' +
                '}';
    }

    public String getR_NO() {
        return R_NO;
    }

    public void setR_NO(String r_NO) {
        R_NO = r_NO;
    }

    public String getR_NAME() {
        return R_NAME;
    }

    public void setR_NAME(String r_NAME) {
        R_NAME = r_NAME;
    }

    public String getR_TIME() {
        return R_TIME;
    }

    public void setR_TIME(String r_TIME) {
        R_TIME = r_TIME;
    }

    public String getR_PROGRESS() {
        return R_PROGRESS;
    }

    public void setR_PROGRESS(String r_PROGRESS) {
        R_PROGRESS = r_PROGRESS;
    }

    public String getR_CONTENT() {
        return R_CONTENT;
    }

    public void setR_CONTENT(String r_CONTENT) {
        R_CONTENT = r_CONTENT;
    }

    public String getR_KEYPOINT() {
        return R_KEYPOINT;
    }

    public void setR_KEYPOINT(String r_KEYPOINT) {
        R_KEYPOINT = r_KEYPOINT;
    }

    public String getR_CONTRACT() {
        return R_CONTRACT;
    }

    public void setR_CONTRACT(String r_CONTRACT) {
        R_CONTRACT = r_CONTRACT;
    }

    public ReportBean(String r_NO, String r_NAME, String r_TIME, String r_PROGRESS, String r_CONTENT, String r_KEYPOINT, String r_CONTRACT) {
        R_NO = r_NO;
        R_NAME = r_NAME;
        R_TIME = r_TIME;
        R_PROGRESS = r_PROGRESS;
        R_CONTENT = r_CONTENT;
        R_KEYPOINT = r_KEYPOINT;
        R_CONTRACT = r_CONTRACT;
    }
}
