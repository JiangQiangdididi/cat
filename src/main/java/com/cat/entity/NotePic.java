package com.cat.entity;

public class NotePic {
    private Integer id;

    private Integer noteId;

    private Integer picId;

    public NotePic(Integer id, Integer noteId, Integer picId) {
        this.id = id;
        this.noteId = noteId;
        this.picId = picId;
    }

    public NotePic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }
}