package com.cat.controller;

import com.cat.common.Const;
import com.cat.common.ResponseCode;
import com.cat.common.ServerResponse;
import com.cat.pojo.Cat;
import com.cat.pojo.Man;
import com.cat.pojo.Note;
import com.cat.pojo.Praise;
import com.cat.service.INoteService;
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
import java.util.Date;

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

    @Autowired
    private INoteService iNoteService;


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
    @RequestMapping("note_detail.do")
    @ResponseBody
    public ServerResponse<Note> getNoteDetail(Integer noteId, HttpSession session){
        Man man = (Man) session.getAttribute(Const.CURRENT_USER);
        if (man == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iNoteService.getDetail(noteId);
    }


    // 处理用户点赞行为
    @RequestMapping("praise.do")
    @ResponseBody
    public ServerResponse getPraise(HttpSession session, Integer id){
        Man man = (Man) session.getAttribute(Const.CURRENT_USER);
        if (man == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        System.out.println("点赞模块:" + id);
        // 查询是否有该用户的点赞记录
        Praise praise = iNoteService.findPraise(id);
        if (praise != null) {
            System.out.println("有点赞记录");
            // 如果有点赞记录， 则删除该记录 同时日记点赞数-1
            // 删除记录
            iNoteService.deletePraise(id);

            // 根据点赞id 找到文章
            ServerResponse<Note> note = iNoteService.findNote(id);
            Note note1 = note.getData();
            // 文章数-1
            note1.setPraiseNum(note1.getPraiseNum()-1);
            // 更新文章点赞数
            iNoteService.updatePraiseNum(note1);
            return ServerResponse.createBySuccess("点赞-1");
        }else{
            // 如果没有这条点赞数则增加这条记录。 同时文章数+1
            System.out.println("没有记录");
            // 根据点赞id 找到文章
            ServerResponse<Note> note = iNoteService.findNote(id);
            Note note1 = note.getData();
            // 添加记录
            Praise praise1 = new Praise();
            praise1.setManId(man.getId());
            praise1.setContentId(note1.getId());
            iNoteService.addPraise(praise1);

            // 文章数+1
            note1.setPraiseNum(note1.getPraiseNum()+1);
            // 更新文章点赞数
            iNoteService.updatePraiseNum(note1);
        }
        return ServerResponse.createBySuccess(praise);
    }
}
