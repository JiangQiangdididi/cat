package com.cat.dao;

import com.cat.entity.CatNote;

public interface CatNoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CatNote record);

    int insertSelective(CatNote record);

    CatNote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CatNote record);

    int updateByPrimaryKey(CatNote record);
}