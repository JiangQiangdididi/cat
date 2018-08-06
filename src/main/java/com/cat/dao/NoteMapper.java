package com.cat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cat.entity.Note;

public interface NoteMapper {	

    /**
     * 帖子信息
     * @param note
     * @return
     */
	int insertNote(Note note);
    
	/**
     * 查询帖子
     * @param id
     * @return
     */
    Note findNote(@Param("id") Integer noteId);   

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
    int updateNote(Note note);

}
