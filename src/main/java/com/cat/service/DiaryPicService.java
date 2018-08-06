package com.cat.service;

import com.cat.entity.DiaryPic;

public interface DiaryPicService {
	/**
     * 日志和图片关系
     * @param diary
     * @return
     */
	boolean insertDiaryPic(DiaryPic diaryPic);
    
    /**
     * 根据id删除关联
     * @param diary
     * @return
     */
	boolean deleteOneById(Integer id);
}
