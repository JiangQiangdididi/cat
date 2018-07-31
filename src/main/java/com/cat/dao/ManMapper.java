package com.cat.dao;

import com.cat.entity.Man;
import org.apache.ibatis.annotations.Param;

public interface ManMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Man record);

    int insertSelective(Man record);

    Man selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Man record);

    int updateByPrimaryKey(Man record);

    int checkUsername(String username);

    Man selectLogin(@Param("username") String username, @Param("password") String password);
}