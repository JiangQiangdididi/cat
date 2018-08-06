package com.cat.service;

import java.util.List;

import com.cat.entity.Note;

public interface NoteService {
	/**
     * 帖子信息
     * @param note
     * @return
     */
	boolean insertNote(Note note);
    
	/**
     * 查询帖子
     * @param id
     * @return
     */
    Note findNote(Integer noteId);   

    /**
     * 查询所有帖子
     * @return
     */
    List<Note> findAll();

    /**
     * 更改帖子信息
     * @param note
     * @return
     */
    boolean updateNote(Note note);
}
