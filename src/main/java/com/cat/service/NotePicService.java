package com.cat.service;

import com.cat.entity.NotePic;

public interface NotePicService {
	/**
     * 帖子和图片关系
     * @param note
     * @return
     */
	boolean insertNotePic(NotePic notePic);
    
    /**
     * 根据id删除关联
     * @param note
     * @return
     */
	boolean deleteOneById(Integer id);
}
