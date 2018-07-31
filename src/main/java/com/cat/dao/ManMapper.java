package com.cat.dao;


import com.cat.entity.Man;
import org.apache.ibatis.annotations.Param;


public interface ManMapper {
    /**
     * 检查用户名是否存在
     * @param
     * @return
     */
    int checkUsername(@Param("logname") String logname);


    /**
     * 注册信息
     * @param man
     * @return
     */
    Integer insertMan(Man man);

    Integer findAll();

    /**
     * 修改密码
     * @return
     */
    Integer updatePassword(Man man);


    /**
     * 添加个人信息
     * @param man
     * @return
     */
    Integer updateManInfo(Man man);
}