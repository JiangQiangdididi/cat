package com.cat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cat.entity.Diary;

public interface DiaryMapper {	

    /**
     * 日志信息
     * @param diary
     * @return
     */
	int insertDiary(Diary diary);
    
	/**
     * 查询日志
     * @param id
     * @return
     */
    Diary findDiary(@Param("id") Integer diaryId);   

    /**
     * 根据catId查询所有日志
     * @param catId
     * @return
     */
    List<Diary> findByCatId(@Param("catId") Integer catId);

    /**
     * 更改日志信息
     * @param diary
     * @return
     */
    int updateDiary(Diary diary);

}
