package com.cat.controller;

import com.cat.common.Const;
import com.cat.common.ResponseCode;
import com.cat.common.ServerResponse;
import com.cat.entity.Man;
import com.cat.service.IUserService;
import com.cat.vo.CatVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: LR
 * @Descriprition: 用户登录功能开发
 * @Date: Created in 9:55 2018/7/16
 * @Modified By:
 **/

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody // 将返回结果序列化为JSON
    public ServerResponse<Man> login(String username, String password, HttpSession session){
        ServerResponse<Man> response = iUserService.login(username, password);
        if (response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @RequestMapping(value = "get_user_info.do", method = RequestMethod.POST)
    @ResponseBody
    // 获取用户个人信息
    public ServerResponse<Man> getUserInfo(HttpSession session){
        Man user = (Man) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户为登录，无法获取当前的用户信息");
    }

    @RequestMapping("get_my_favorite.do")
    @ResponseBody
    // 我的收藏
    public ServerResponse<CatVo> myCatList(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageNum", defaultValue = "10") int pageSize){
        Man man = (Man) session.getAttribute(Const.CURRENT_USER);
        if (man == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iUserService.getListByManId(man.getId(), pageNum, pageSize);
    }

    @RequestMapping("get_my_adopt.do")
    @ResponseBody
    // 我的领养
    public ServerResponse<PageInfo> getCatList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "10")int pageSize,
                                           HttpSession session){
        Man man = (Man) session.getAttribute(Const.CURRENT_USER);
        if (man == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iUserService.getCatList(man.getId(), pageNum, pageSize);
    }

    @RequestMapping("my_note.do")
    @ResponseBody
    //关于我和猫猫
    public ServerResponse<PageInfo> getCatNote(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10")int pageSize,
                                               HttpSession session){
        Man man = (Man) session.getAttribute(Const.CURRENT_USER);
        if (man == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iUserService.getCatNote(man.getId(), pageNum, pageSize);
    }
}
