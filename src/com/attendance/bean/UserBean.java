package com.attendance.bean;

public class UserBean {
    public String e_NO;
    public String e_NAME;
    public String e_PASSWD;
    public String e_DEPT;
    public String e_JOB;

    public UserBean() {
    }

    public String e_REGISTTIME;
    public String e_SEX;
    public String e_PHONE;
    public String e_BIRTHDAY;
    public String e_EMAIL;
    public String e_ISADMIN;

    public String getE_NO() {
        return e_NO;
    }

    public void setE_NO(String e_NO) {
        this.e_NO = e_NO;
    }

    public String getE_NAME() {
        return e_NAME;
    }

    public void setE_NAME(String e_NAME) {
        this.e_NAME = e_NAME;
    }

    public String getE_PASSWD() {
        return e_PASSWD;
    }

    public void setE_PASSWD(String e_PASSWD) {
        this.e_PASSWD = e_PASSWD;
    }

    public String getE_DEPT() {
        return e_DEPT;
    }

    public void setE_DEPT(String e_DEPT) {
        this.e_DEPT = e_DEPT;
    }

    public String getE_JOB() {
        return e_JOB;
    }

    public void setE_JOB(String e_JOB) {
        this.e_JOB = e_JOB;
    }

    public String getE_REGISTTIME() {
        return e_REGISTTIME;
    }

    public void setE_REGISTTIME(String e_REGISTTIME) {
        this.e_REGISTTIME = e_REGISTTIME;
    }

    public String getE_SEX() {
        return e_SEX;
    }

    public void setE_SEX(String e_SEX) {
        this.e_SEX = e_SEX;
    }

    public String getE_PHONE() {
        return e_PHONE;
    }

    public void setE_PHONE(String e_PHONE) {
        this.e_PHONE = e_PHONE;
    }

    public String getE_BIRTHDAY() {
        return e_BIRTHDAY;
    }

    public void setE_BIRTHDAY(String e_BIRTHDAY) {
        this.e_BIRTHDAY = e_BIRTHDAY;
    }

    public String getE_EMAIL() {
        return e_EMAIL;
    }

    public void setE_EMAIL(String e_EMAIL) {
        this.e_EMAIL = e_EMAIL;
    }

    public String getE_ISADMIN() {
        return e_ISADMIN;
    }

    public void setE_ISADMIN(String e_ISADMIN) {
        this.e_ISADMIN = e_ISADMIN;
    }

    public UserBean(String e_NO, String e_NAME, String e_PASSWD, String e_ISADMIN) {
        this.e_NO = e_NO;
        this.e_NAME = e_NAME;
        this.e_PASSWD = e_PASSWD;
        this.e_ISADMIN = e_ISADMIN;
    }

    public UserBean(String e_NO, String e_NAME, String e_PASSWD, String e_DEPT, String e_JOB, String e_REGISTTIME, String e_SEX, String e_PHONE, String e_BIRTHDAY, String e_EMAIL, String e_ISADMIN) {
        this.e_NO = e_NO;
        this.e_NAME = e_NAME;
        this.e_PASSWD = e_PASSWD;
        this.e_DEPT = e_DEPT;
        this.e_JOB = e_JOB;
        this.e_REGISTTIME = e_REGISTTIME;
        this.e_SEX = e_SEX;
        this.e_PHONE = e_PHONE;
        this.e_BIRTHDAY = e_BIRTHDAY;
        this.e_EMAIL = e_EMAIL;
        this.e_ISADMIN = e_ISADMIN;
    }
}