package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.dao.DiaryMapper;
import com.cat.entity.Diary;
import com.cat.service.DiaryService;
@Service
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	private DiaryMapper diaryMapper;
	/**
     * 日志信息
     * @param diary
     * @return
     */
	@Override
	public boolean insertDiary(Diary diary) {
		int count=diaryMapper.insertDiary(diary);
		return count==1?true:false;
	}
	/**
     * 查询日志
     * @param id
     * @return
     */
	@Override
	public Diary findDiary(Integer diaryId) {
		return diaryMapper.findDiary(diaryId);
	}
	/**
     * 根据catId查询所有日志
     * @return
     */
	@Override
	public List<Diary> findByCatId(Integer catId) {
		return diaryMapper.findByCatId(catId);
	}
	/**
     * 更改日志信息
     * @param diary
     * @return
     */
	@Override
	public boolean updateDiary(Diary diary) {
		int count=diaryMapper.updateDiary(diary);
		return count==1?true:false;
	}

}
