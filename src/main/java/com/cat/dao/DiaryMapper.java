package com.cat.dao;

import com.cat.entity.Diary;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 19:58 2018/7/30
 * @Modified By:
 **/
public interface DiaryMapper {

    Diary selectDiary();

    Diary selectDiaryById(Integer id);

}
