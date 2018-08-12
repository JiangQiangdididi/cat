package com.cat.service.impl;

import com.cat.common.Const;
import com.cat.common.ResponseCode;
import com.cat.common.ServerResponse;
import com.cat.dao.CatMapper;
import com.cat.dao.DiaryMapper;
import com.cat.pojo.Cat;
import com.cat.pojo.Diary;
import com.cat.service.IMainService;
import com.cat.vo.CatListVo;
import com.cat.vo.CatVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 11:29 2018/7/18
 * @Modified By:
 **/

@Service("iManService")
public class MainServiceImpl implements IMainService {

    @Autowired
    private CatMapper catMapper;

    @Autowired
    private DiaryMapper diaryMapper;

    // 获取帖子详情信息
    public ServerResponse<Diary> getDiaryDetial(Integer id){

        Diary diary = diaryMapper.selectDiaryById(id);
        if (diary == null) {
            ServerResponse.createByErrorMessage("此帖子不存在");
        }

        return ServerResponse.createBySuccess(diary);
    }


    private CatListVo assembleCatListVo(Cat cat){
        CatListVo catVoList = new CatListVo();
        catVoList.setName(cat.getName());
        catVoList.setCatPic(cat.getPic());
        catVoList.setGender(cat.getGender());
        catVoList.setBrith(cat.getBirth());
        catVoList.setHealthyStatus(cat.getHealthy());

        return catVoList;
    }

    // 获取帖子列表
    public ServerResponse<PageInfo> getCatList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Cat> catList = catMapper.getCatList();

        List<CatListVo> catListVoList = Lists.newArrayList();

        for (Cat catItem : catList) {
            CatListVo catListVo = assembleCatListVo(catItem);
            catListVoList.add(catListVo);
        }

        PageInfo pageInfo = new PageInfo(catList);
        pageInfo.setList(catListVoList);

        return ServerResponse.createBySuccess(pageInfo);
    }

}
