package com.cat.entity;

import java.util.Date;

public class Pic {
    private Integer id;

    private Integer catId;

    private Date editTime;

    private String picUrl;

    private Byte yn;

    private Byte detailShow;

    private Byte diaryUse;

    private Byte articleUse;

    public Pic(Integer id, Integer catId, Date editTime, String picUrl, Byte yn, Byte detailShow, Byte diaryUse, Byte articleUse) {
        this.id = id;
        this.catId = catId;
        this.editTime = editTime;
        this.picUrl = picUrl;
        this.yn = yn;
        this.detailShow = detailShow;
        this.diaryUse = diaryUse;
        this.articleUse = articleUse;
    }

    public Pic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Byte getYn() {
        return yn;
    }

    public void setYn(Byte yn) {
        this.yn = yn;
    }

    public Byte getDetailShow() {
        return detailShow;
    }

    public void setDetailShow(Byte detailShow) {
        this.detailShow = detailShow;
    }

    public Byte getDiaryUse() {
        return diaryUse;
    }

    public void setDiaryUse(Byte diaryUse) {
        this.diaryUse = diaryUse;
    }

    public Byte getArticleUse() {
        return articleUse;
    }

    public void setArticleUse(Byte articleUse) {
        this.articleUse = articleUse;
    }
}