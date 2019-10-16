package com.attendance.bean;

public class OvertimeBean {
    private String O_NO;
    private String O_NAME;
    private String O_TIME;
    private String O_START;
    private String O_END;
    private String O_REASON;

    @Override
    public String toString() {
        return "OvertimeBean{" +
                "O_NO='" + O_NO + '\'' +
                ", O_NAME='" + O_NAME + '\'' +
                ", O_TIME='" + O_TIME + '\'' +
                ", O_START='" + O_START + '\'' +
                ", O_END='" + O_END + '\'' +
                ", O_REASON='" + O_REASON + '\'' +
                '}';
    }

    public String getO_NO() {
        return O_NO;
    }

    public void setO_NO(String o_NO) {
        O_NO = o_NO;
    }

    public String getO_NAME() {
        return O_NAME;
    }

    public void setO_NAME(String o_NAME) {
        O_NAME = o_NAME;
    }

    public String getO_TIME() {
        return O_TIME;
    }

    public void setO_TIME(String o_TIME) {
        O_TIME = o_TIME;
    }

    public String getO_START() {
        return O_START;
    }

    public void setO_START(String o_START) {
        O_START = o_START;
    }

    public String getO_END() {
        return O_END;
    }

    public void setO_END(String o_END) {
        O_END = o_END;
    }

    public String getO_REASON() {
        return O_REASON;
    }

    public void setO_REASON(String o_REASON) {
        O_REASON = o_REASON;
    }

    public OvertimeBean(String o_NO, String o_NAME, String o_TIME, String o_START, String o_END, String o_REASON) {
        O_NO = o_NO;
        O_NAME = o_NAME;
        O_TIME = o_TIME;
        O_START = o_START;
        O_END = o_END;
        O_REASON = o_REASON;
    }
}
