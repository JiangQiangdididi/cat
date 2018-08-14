package com.cat.dao;

import com.cat.pojo.Praise;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 13:30 2018/8/14
 * @Modified By:
 **/
public interface PraiseMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Praise praise);

    int insertSelective(Praise praise);

    Praise selectByPrimaryKey(Integer id);

}
