package com.cat.entity;

public class CatNote {
    private Integer id;

    private Integer cat;

    private Integer note;

    public CatNote(Integer id, Integer cat, Integer note) {
        this.id = id;
        this.cat = cat;
        this.note = note;
    }

    public CatNote() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCat() {
        return cat;
    }

    public void setCat(Integer cat) {
        this.cat = cat;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}