package com.lenovo.newThink.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lenovo.newThink.dao.NewInspirationMapper;
import com.lenovo.newThink.vo.NewInspirationVo;

@Component("newInspirationDao")
public class NewInspirationDao implements NewInspirationMapper{

	static final Logger logger = Logger.getLogger(NewInspirationDao.class);
	@Autowired
	private NewInspirationMapper newInspirationMapper;
	public NewInspirationVo getNewInspiration(long id) {
		// TODO Auto-generated method stub
		return newInspirationMapper.getNewInspiration(id);
	}

	public List<NewInspirationVo> getNewInspirationList() {
		// TODO Auto-generated method stub
		return newInspirationMapper.getNewInspirationList();
	}

	public void insertNewInspiration(NewInspirationVo newInspirationVo) {
		// TODO Auto-generated method stub
		newInspirationMapper.insertNewInspiration(newInspirationVo);
	}

	public void deleteNewInspiration(long id) {
		// TODO Auto-generated method stub
		newInspirationMapper.deleteNewInspiration(id);
	}

	public void modifyNewInspiration(NewInspirationVo newInspirationVo) {
		// TODO Auto-generated method stub
		newInspirationMapper.modifyNewInspiration(newInspirationVo);
	}

	public List<NewInspirationVo> getNewInspirationById(long id) {
		// TODO Auto-generated method stub
		return newInspirationMapper.getNewInspirationById(id);
	}

}
