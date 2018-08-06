package com.cat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cat.entity.Diary;
import com.cat.entity.DiaryPic;

public interface DiaryPicMapper {	

    /**
     * 日志和图片关系
     * @param diary
     * @return
     */
	int insertDiaryPic(DiaryPic diaryPic);
    
    /**
     * 根据id删除关联
     * @param diary
     * @return
     */
	int deleteOneById(@Param("id")Integer id);
}
