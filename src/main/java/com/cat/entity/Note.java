package com.cat.entity;

import java.util.Date;

public class Note {
    private Integer id;

    private Integer man;

    private Date time;

    private String title;

    private String introduct;

    private String content;

    public Note(Integer id, Integer man, Date time, String title, String introduct, String content) {
        this.id = id;
        this.man = man;
        this.time = time;
        this.title = title;
        this.introduct = introduct;
        this.content = content;
    }

    public Note() {
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntroduct() {
        return introduct;
    }

    public void setIntroduct(String introduct) {
        this.introduct = introduct == null ? null : introduct.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}