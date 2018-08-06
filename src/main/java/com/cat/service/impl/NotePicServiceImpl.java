package com.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.dao.NotePicMapper;
import com.cat.entity.NotePic;
import com.cat.service.NotePicService;
@Service
public class NotePicServiceImpl implements NotePicService {
	@Autowired
	private NotePicMapper notePicMapper;
	@Override
	public boolean insertNotePic(NotePic notePic) {
		int count=notePicMapper.insertNotePic(notePic);
		return count==1?true:false;
	}

	@Override
	public boolean deleteOneById(Integer id) {
		int count=notePicMapper.deleteOneById(id);
		return count==1?true:false;
	}

}
