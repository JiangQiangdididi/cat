package com.cat.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Man {
    private Integer id;

    private String name;

    private String sex;

    private String borntime;

    private Integer gender;

    private String phone;

    private String mail;

    private String logname;

    private String password;

    private Date buildtime;

    private String address;
    private Byte yn;


}