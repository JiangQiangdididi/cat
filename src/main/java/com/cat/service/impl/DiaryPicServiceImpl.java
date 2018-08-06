package com.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.dao.DiaryPicMapper;
import com.cat.entity.DiaryPic;
import com.cat.service.DiaryPicService;
@Service
public class DiaryPicServiceImpl implements DiaryPicService {
	@Autowired
	private DiaryPicMapper diaryPicMapper;
	@Override
	public boolean insertDiaryPic(DiaryPic diaryPic) {
		int count=diaryPicMapper.insertDiaryPic(diaryPic);
		return count==1?true:false;
	}

	@Override
	public boolean deleteOneById(Integer id) {
		int count=diaryPicMapper.deleteOneById(id);
		return count==1?true:false;
	}

}
