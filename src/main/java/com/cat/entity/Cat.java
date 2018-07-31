package com.cat.entity;

import java.util.Date;

public class Cat {
    private Integer id;

    private String name;

    private Byte gender;

    private String pic;

    private Integer healthy;

    private Date birth;

    private Integer weight;

    private Integer len;

    private Integer variety;

    private Integer man;

    private Byte yn;

    public Cat(Integer id, String name, Byte gender, String pic, Integer healthy, Date birth, Integer weight, Integer len, Integer variety, Integer man, Byte yn) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.pic = pic;
        this.healthy = healthy;
        this.birth = birth;
        this.weight = weight;
        this.len = len;
        this.variety = variety;
        this.man = man;
        this.yn = yn;
    }

    public Cat() {
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getHealthy() {
        return healthy;
    }

    public void setHealthy(Integer healthy) {
        this.healthy = healthy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Integer getVariety() {
        return variety;
    }

    public void setVariety(Integer variety) {
        this.variety = variety;
    }

    public Integer getMan() {
        return man;
    }

    public void setMan(Integer man) {
        this.man = man;
    }

    public Byte getYn() {
        return yn;
    }

    public void setYn(Byte yn) {
        this.yn = yn;
    }
}