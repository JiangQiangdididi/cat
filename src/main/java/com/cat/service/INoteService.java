package com.cat.service;

import com.cat.common.ServerResponse;
import com.cat.pojo.Man;
import com.cat.pojo.Note;
import com.cat.pojo.Praise;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 9:25 2018/7/17
 * @Modified By:
 **/
public interface INoteService {

    ServerResponse<Note> getDetail(Integer noteId);

    ServerResponse<Note> findNote(Integer id);

    Praise findPraise(Integer id);

    ServerResponse<String> deletePraise(Integer id);

    ServerResponse updatePraiseNum(Note note);

    ServerResponse addPraise(Praise praise);
}
