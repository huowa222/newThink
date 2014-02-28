package com.lenovo.newThink.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lenovo.newThink.dao.NewAnotationMapper;
import com.lenovo.newThink.vo.NewAnotationVo;

@Component("newAnotationDao")
public class NewAnotationDao implements NewAnotationMapper {

	static final Logger logger = Logger.getLogger(NewAnotationDao.class);
	@Autowired
	private NewAnotationMapper newAnotationMapper;

	public NewAnotationVo getNewAnotation(long id) {
		// TODO Auto-generated method stub
		NewAnotationVo newAnotationVo = newAnotationMapper.getNewAnotation(id);
		return newAnotationVo;
	}

	public List<NewAnotationVo> getNewAnotationList() {
		// TODO Auto-generated method stub

		return newAnotationMapper.getNewAnotationList();
	}

	public void insertNewAnotation(NewAnotationVo newAnotationVo) {
		// TODO Auto-generated method stub

		newAnotationMapper.insertNewAnotation(newAnotationVo);
	}

	public void deleteNewAnotation(long id) {
		// TODO Auto-generated method stub

		newAnotationMapper.deleteNewAnotation(id);
	}

	public void modifyNewAnotation(NewAnotationVo newAnotationVo) {
		// TODO Auto-generated method stub
		newAnotationMapper.modifyNewAnotation(newAnotationVo);
	}

	public List<NewAnotationVo> getNewAnotationById(long id) {
		// TODO Auto-generated method stub
		List<NewAnotationVo> a = newAnotationMapper.getNewAnotationById(id);
		return a;
	}

}
