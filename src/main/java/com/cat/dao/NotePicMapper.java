package com.cat.dao;

import org.apache.ibatis.annotations.Param;

import com.cat.entity.NotePic;

public interface NotePicMapper {	

    /**
     * 帖子和图片关系
     * @param note
     * @return
     */
	int insertNotePic(NotePic notePic);
    
    /**
     * 根据id删除关联
     * @param note
     * @return
     */
	int deleteOneById(@Param("id")Integer id);
}
