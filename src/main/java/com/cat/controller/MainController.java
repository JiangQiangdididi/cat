package com.cat.controller;

import com.cat.common.ServerResponse;
import com.cat.pojo.Diary;
import com.cat.service.IMainService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LR
 * @Descriprition: 首页
 * @Date: Created in 11:27 2018/7/18
 * @Modified By:
 **/
@Controller
@RequestMapping("/main/")
public class MainController {

    @Autowired
    private IMainService iMainService;


    @RequestMapping("diary.do")
    @ResponseBody
    public ServerResponse<Diary> getDiaryDetial(Integer id){
        return iMainService.getDiaryDetial(id);
    }

    // 获取帖子列表
    @RequestMapping("catList.do")
    @ResponseBody
    public ServerResponse<PageInfo> catList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageNum", defaultValue = "10") int pageSize){

        return iMainService.getCatList(pageNum, pageSize);
    }
}
