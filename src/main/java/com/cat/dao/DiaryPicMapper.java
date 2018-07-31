package com.cat.dao;

import com.cat.entity.DiaryPic;

import java.util.List;

public interface DiaryPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiaryPic record);

    int insertSelective(DiaryPic record);

    DiaryPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiaryPic record);

    int updateByPrimaryKey(DiaryPic record);

    List<String> selectPicById(Integer diaryId);
}