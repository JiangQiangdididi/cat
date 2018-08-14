package com.cat.service.impl;

import com.cat.common.ServerResponse;
import com.cat.dao.NoteMapper;
import com.cat.dao.PraiseMapper;
import com.cat.pojo.Note;
import com.cat.pojo.Praise;
import com.cat.service.INoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LR
 * @Descriprition: 日记相关功能开发
 * @Date: Created in 9:26 2018/7/17
 * @Modified By:
 **/
@Slf4j
@Service("iNoteService")
public class NoteServiceImpl implements INoteService {

    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private PraiseMapper praiseMapper;

    // 查看日记详情
    public ServerResponse<Note> getDetail(Integer noteId){

        // 从数据库中获取日记信息
        Note note = noteMapper.selectByPrimaryKey(noteId);
        if (note != null) {
            return ServerResponse.createBySuccess(note);
        }
        return ServerResponse.createByErrorMessage("日记不存在");
    }

    // 查找日记
    public ServerResponse<Note> findNote(Integer id){
        Note note = noteMapper.selectByPrimaryKey(id);
        if (note != null) {
            return ServerResponse.createBySuccess(note);
        }
        return ServerResponse.createByErrorMessage("该日记不存在");
    }


    // 查找点赞记录
    public Praise findPraise(Integer id){
        Praise praise = praiseMapper.selectByPrimaryKey(id);
        return praise;
    }

    // 删除点赞记录
    public ServerResponse<String> deletePraise(Integer id){
        int result = praiseMapper.deleteByPrimaryKey(id);
        if (result > 0){
            return ServerResponse.createBySuccess("删除点赞成功");
        }
        return ServerResponse.createByErrorMessage("删除点赞失败");
    }

    // 更新点赞数
    public ServerResponse updatePraiseNum(Note note){
        int result = noteMapper.updateByPrimaryKeySelective(note);
        if (result > 0){
            return ServerResponse.createBySuccess("更新点赞数成功");
        }
        return ServerResponse.createByErrorMessage("更新点赞数失败");
    }

    // 添加点赞记录
    public ServerResponse addPraise(Praise praise){

        int result = praiseMapper.insertSelective(praise);
        if (result > 0){
            log.info("添加点赞记录成功");
        }
        log.info("添加点赞记录失败");
        return ServerResponse.createBySuccess();
    }


}
