package com.cat.service;

import com.cat.common.ServerResponse;
import com.cat.pojo.Diary;
import com.cat.vo.CatVo;
import com.github.pagehelper.PageInfo;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 11:28 2018/7/18
 * @Modified By:
 **/
public interface IMainService {

    ServerResponse<Diary> getDiaryDetial(Integer id);

    ServerResponse<PageInfo> getCatList(int pageNum, int pageSize);
}
