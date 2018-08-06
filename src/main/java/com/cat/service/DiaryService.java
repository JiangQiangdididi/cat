package com.cat.service;

import java.util.List;

import com.cat.entity.Diary;

public interface DiaryService {
	/**
     * 日志信息
     * @param diary
     * @return
     */
	boolean insertDiary(Diary diary);
    
	/**
     * 查询日志
     * @param id
     * @return
     */
    Diary findDiary(Integer id);   

    /**
     * 根据catId查询所有日志
     * @return
     */
    List<Diary> findByCatId(Integer catId);

    /**
     * 更改日志信息
     * @param diary
     * @return
     */
    boolean updateDiary(Diary diary);
}
