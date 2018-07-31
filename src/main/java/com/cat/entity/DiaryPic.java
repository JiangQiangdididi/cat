package com.cat.entity;

public class DiaryPic {
    private Integer id;

    private Integer diaryId;

    private Integer picId;

    public DiaryPic(Integer id, Integer diaryId, Integer picId) {
        this.id = id;
        this.diaryId = diaryId;
        this.picId = picId;
    }

    public DiaryPic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }
}