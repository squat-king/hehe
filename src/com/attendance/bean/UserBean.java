package com.attendance.bean;

public class UserBean {
    private String E_NO;
    private String E_NAME;
    private String E_PASSWD;
    private String E_DEPT;
    private String E_JOB;
    private String E_REGISTTIME;
    private String E_SEX;
    private String E_PHONE;
    private String E_BIRTHDAY;
    private String E_EMAIL;
    private Boolean E_ISADMIN;

    public UserBean(String e_NO, String e_NAME, String e_PASSWD, String e_DEPT, String e_JOB, String e_REGISTTIME, String e_SEX, String e_PHONE, String e_BIRTHDAY, String e_EMAIL, Boolean e_ISADMIN) {
        E_NO = e_NO;
        E_NAME = e_NAME;
        E_PASSWD = e_PASSWD;
        E_DEPT = e_DEPT;
        E_JOB = e_JOB;
        E_REGISTTIME = e_REGISTTIME;
        E_SEX = e_SEX;
        E_PHONE = e_PHONE;
        E_BIRTHDAY = e_BIRTHDAY;
        E_EMAIL = e_EMAIL;
        E_ISADMIN = e_ISADMIN;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "E_NO='" + E_NO + '\'' +
                ", E_NAME='" + E_NAME + '\'' +
                ", E_PASSWD='" + E_PASSWD + '\'' +
                ", E_DEPT='" + E_DEPT + '\'' +
                ", E_JOB='" + E_JOB + '\'' +
                ", E_REGISTTIME='" + E_REGISTTIME + '\'' +
                ", E_SEX='" + E_SEX + '\'' +
                ", E_PHONE='" + E_PHONE + '\'' +
                ", E_BIRTHDAY='" + E_BIRTHDAY + '\'' +
                ", E_EMAIL='" + E_EMAIL + '\'' +
                ", E_ISADMIN=" + E_ISADMIN +
                '}';
    }

    public UserBean(String e_NO, String e_NAME, String e_PASSWD, Boolean e_ISADMIN) {
        E_NO = e_NO;
        E_NAME = e_NAME;
        E_PASSWD = e_PASSWD;
        E_ISADMIN = e_ISADMIN;
    }

    public String getE_NO() {
        return E_NO;
    }

    public String getE_NAME() {
        return E_NAME;
    }

    public String getE_PASSWD() {
        return E_PASSWD;
    }

    public String getE_DEPT() {
        return E_DEPT;
    }

    public String getE_JOB() {
        return E_JOB;
    }

    public String getE_REGISTTIME() {
        return E_REGISTTIME;
    }

    public String getE_SEX() {
        return E_SEX;
    }

    public String getE_PHONE() {
        return E_PHONE;
    }

    public String getE_BIRTHDAY() {
        return E_BIRTHDAY;
    }

    public String getE_EMAIL() {
        return E_EMAIL;
    }

    public Boolean getE_ISADMIN() {
        return E_ISADMIN;
    }
}