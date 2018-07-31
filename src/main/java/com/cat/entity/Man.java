package com.cat.entity;

import java.util.Date;

public class Man {
    private Integer id;

    private String name;

    private Byte gender;

    private String phone;

    private String mail;

    private String logname;

    private String password;

    private Date buildtime;

    private Byte yn;

    public Man(Integer id, String name, Byte gender, String phone, String mail, String logname, String password, Date buildtime, Byte yn) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.mail = mail;
        this.logname = logname;
        this.password = password;
        this.buildtime = buildtime;
        this.yn = yn;
    }

    public Man() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname == null ? null : logname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Byte getYn() {
        return yn;
    }

    public void setYn(Byte yn) {
        this.yn = yn;
    }
}