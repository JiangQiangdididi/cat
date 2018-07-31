package com.cat.service.impl;


import com.cat.dao.ManMapper;
import com.cat.entity.Man;
import com.cat.service.ManService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 刘文博
 * 2018/7/17 16:04
 */
@Service
public class ManServiceImpl implements ManService {
    @Autowired
   private ManMapper manMapper;

    /**
     * 注册
     * @param man
     * @return
     */
    @Override
    public boolean register(Man man) {
        man.setPassword(DigestUtils.md5Hex(man.getPassword()));
        int count = manMapper.insertMan(man);
        return count==1?true:false;
    }

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @Override
    public String login(String username, String password) {
//        Man man =new Man();
//         = manMapper.checkUsername(man);
//        if (resultCount == 0){
//            return "用户名不存在";
//        }
//        // 登录 MD5加密
//        String md5pwd = DigestUtils.md5Hex(password);// MD5 加密
//        Man man = manMapper.selectLogin(username,md5pwd);
//        if (man == null) {
//            return "密码错误";
//        }

        // 将密码设置为空  防止别人抓包
//        man.setPassword(String.valueOf(StringUtils.isEmpty(password)));
        return "登录成功";
    }

    /**
     * 检查用户名是否存在
     * @param manName
     * @return
     */
    @Override
    public boolean checkManname(String manName) {
        int i = manMapper.checkUsername(manName);
        return i==0?true:false;
    }

    @Override
    public boolean fixPassword(Man man) {
        Integer integer = manMapper.updatePassword(man);
        return integer==1?true:false;
    }

    @Override
    public boolean addManInfo(Man man) {
        Integer integer = manMapper.updateManInfo(man);
        return integer==1?true:false;
    }
}
