package com.cat.service;

import com.cat.common.ServerResponse;
import com.cat.pojo.Note;
import com.cat.pojo.Praise;
import com.github.pagehelper.PageInfo;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 10:03 2018/7/16
 * @Modified By:
 **/
public interface IUserService {

    ServerResponse login(String username, String password);

    ServerResponse getListByManId(Integer manId, int pageNum, int pageSize);

    ServerResponse<PageInfo> getCatList(Integer manId, int pageNum, int pageSize);

    ServerResponse<PageInfo> getCatNote(Integer manId, int pageNum, int pageSize);


}
