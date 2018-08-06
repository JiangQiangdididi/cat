package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.dao.NoteMapper;
import com.cat.entity.Note;
import com.cat.service.NoteService;
@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteMapper noteMapper;
	/**
     * 帖子信息
     * @param note
     * @return
     */
	@Override
	public boolean insertNote(Note note) {
		int count=noteMapper.insertNote(note);
		return count==1?true:false;
	}
	/**
     * 查询帖子
     * @param id
     * @return
     */
	@Override
	public Note findNote(Integer noteId) {
		return noteMapper.findNote(noteId);
	}
	/**
     * 查询所有帖子
     * @return
     */
	@Override
	public List<Note> findAll() {
		return noteMapper.findAll();
	}
	/**
     * 更改帖子信息
     * @param note
     * @return
     */
	@Override
	public boolean updateNote(Note note) {
		int count=noteMapper.updateNote(note);
		return count==1?true:false;
	}

}
