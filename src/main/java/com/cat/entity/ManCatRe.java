package com.cat.entity;

import java.util.Date;

public class ManCatRe {
    private Integer id;

    private Integer man;

    private Integer cat;

    private Date time;

    public ManCatRe(Integer id, Integer man, Integer cat, Date time) {
        this.id = id;
        this.man = man;
        this.cat = cat;
        this.time = time;
    }

    public ManCatRe() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMan() {
        return man;
    }

    public void setMan(Integer man) {
        this.man = man;
    }

    public Integer getCat() {
        return cat;
    }

    public void setCat(Integer cat) {
        this.cat = cat;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}