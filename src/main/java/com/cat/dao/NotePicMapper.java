package com.cat.dao;

import com.cat.entity.NotePic;

public interface NotePicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NotePic record);

    int insertSelective(NotePic record);

    NotePic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NotePic record);

    int updateByPrimaryKey(NotePic record);
}