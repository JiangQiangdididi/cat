package com.cat.dao;

import com.cat.pojo.Cat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cat record);

    int insertSelective(Cat record);

    Cat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cat record);

    int updateByPrimaryKey(Cat record);

    Cat selectById(Integer id);

    List<Cat> getCatList();

    List<Cat> getCatListById(@Param("manId") Integer manId);
}