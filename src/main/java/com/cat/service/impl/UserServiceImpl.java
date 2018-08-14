package com.cat.service.impl;

import com.cat.common.ServerResponse;
import com.cat.dao.CatMapper;
import com.cat.dao.ManMapper;
import com.cat.dao.NoteMapper;
import com.cat.dao.PraiseMapper;
import com.cat.pojo.Cat;
import com.cat.pojo.Man;
import com.cat.pojo.Note;
import com.cat.pojo.Praise;
import com.cat.service.IUserService;
import com.cat.utils.MD5Util;
import com.cat.vo.CatListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 10:04 2018/7/16
 * @Modified By:
 **/

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private ManMapper manMapper;

    @Autowired
    private CatMapper catMapper;

    @Autowired
    private NoteMapper noteMapper;





    // 登录功能
    public ServerResponse<Man> login(String username, String password){
        // 检查用户名
        int resultCount = manMapper.checkUsername(username);
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        // 登录 MD5加密
        String md5Password =MD5Util.MD5EncodeUtf8(password); // MD5 加密
        Man man = manMapper.selectLogin(username, md5Password);
        if (man == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }

        // 将密码设置为空  防止别人抓包
        man.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", man);
    }

    // 封装猫列表
    private CatListVo assembleCatListVo(Cat cat){
        CatListVo catVoList = new CatListVo();
        catVoList.setName(cat.getName());
        catVoList.setCatPic(cat.getPic());
        catVoList.setGender(cat.getGender());
        catVoList.setBrith(cat.getBirth());
        catVoList.setHealthyStatus(cat.getHealthy());

        return catVoList;
    }

    // 我的收藏
    public ServerResponse<PageInfo> getListByManId(Integer manId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Cat> catList = catMapper.getCatListById(manId);

        List<CatListVo> catListVoList = Lists.newArrayList();

        for (Cat catItem : catList) {
            CatListVo catListVo = assembleCatListVo(catItem);
            catListVoList.add(catListVo);
        }

        PageInfo pageInfo = new PageInfo(catList);
        pageInfo.setList(catListVoList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    // 我的收养
    public ServerResponse<PageInfo> getCatList(Integer manId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Cat> catList = catMapper.getCatListById(manId);

        PageInfo pageInfo =new PageInfo(catList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    // 关于我和猫猫
    public ServerResponse<PageInfo> getCatNote(Integer manId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Note> noteList = noteMapper.selectNoteByManId(manId);

        PageInfo pageInfo =new PageInfo(noteList);
        return ServerResponse.createBySuccess(pageInfo);
    }


}
