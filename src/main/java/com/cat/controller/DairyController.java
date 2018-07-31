package com.cat.controller;

import com.cat.common.ServerResponse;
import com.cat.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LR
 * @Descriprition: 日记功能开发
 * @Date: Created in 9:23 2018/7/17
 * @Modified By:
 **/
@Controller
@RequestMapping("/note/")
public class DairyController {

    @Autowired
    private IDiaryService iDiaryService;

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse detail(Integer userId, String username){
        if(userId == null || username == null){
            ServerResponse.createByErrorMessage("用户ID或用户名不存在");
        }
        return iDiaryService.getDetail(userId, username);
    }
}
