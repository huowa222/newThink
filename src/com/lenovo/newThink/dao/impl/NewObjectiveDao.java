package com.lenovo.newThink.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.lenovo.newThink.dao.NewObjectiveMapper;
import com.lenovo.newThink.vo.NewObjectiveVo;

@Component("newObjectiveDao") 
public class NewObjectiveDao implements NewObjectiveMapper {

	static final Logger logger = Logger.getLogger(NewObjectiveDao.class);
	@Autowired
	private NewObjectiveMapper newObjectiveMapper;
	public NewObjectiveVo getNewObjective(long id) {
		// TODO Auto-generated method stub
		NewObjectiveVo newObjectiveVo = newObjectiveMapper.getNewObjective(id);
		return newObjectiveVo;
	}

	public List<NewObjectiveVo> getNewObjectiveList() {
		// TODO Auto-generated method stub
		return newObjectiveMapper.getNewObjectiveList();
	}

	public void insertNewObjective(NewObjectiveVo newObjectiveVo) {
		// TODO Auto-generated method stub
		newObjectiveMapper.insertNewObjective(newObjectiveVo);
	}

	public void deleteNewObjective(long id) {
		// TODO Auto-generated method stub
		newObjectiveMapper.deleteNewObjective(id);
	}

	public void modifyNewObjective(NewObjectiveVo newObjectiveVo) {
		// TODO Auto-generated method stub
		newObjectiveMapper.modifyNewObjective(newObjectiveVo);
	}

	public List<NewObjectiveVo> getNewObjectiveById(long id) {
		// TODO Auto-generated method stub
		return newObjectiveMapper.getNewObjectiveById(id);
	}

	public List<NewObjectiveVo> getSubObjective(long preObjId) {
		// TODO Auto-generated method stub
		return newObjectiveMapper.getSubObjective(preObjId);
	}

}
