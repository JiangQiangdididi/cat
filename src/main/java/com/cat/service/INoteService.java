package com.cat.service;

import com.cat.common.ServerResponse;
import com.cat.pojo.Note;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 9:25 2018/7/17
 * @Modified By:
 **/
public interface INoteService {

    ServerResponse<Note> getDetail(Integer noteId);
}
