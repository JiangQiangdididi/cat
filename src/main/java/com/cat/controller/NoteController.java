package com.cat.controller;

import com.cat.common.Const;
import com.cat.common.ResponseCode;
import com.cat.common.ServerResponse;
import com.cat.pojo.Man;
import com.cat.pojo.Note;
import com.cat.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: LR
 * @Descriprition: 获取日记
 * @Date: Created in 17:08 2018/8/12
 * @Modified By:
 **/
@Controller
@RequestMapping("/note/")
public class NoteController {

    @Autowired
    private INoteService iNoteService;


}
