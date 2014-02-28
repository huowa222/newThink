package com.lenovo.newThink.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.lenovo.newThink.vo.NewObjectiveVo;

public interface NewObjectiveMapper {
	static final Logger logger = Logger.getLogger(NewObjectiveMapper.class);

	public NewObjectiveVo getNewObjective(long id);
	
	public List<NewObjectiveVo> getNewObjectiveList();
	
	public List<NewObjectiveVo> getNewObjectiveById(long id);
	
	public void insertNewObjective(NewObjectiveVo newObjectiveVo);
	
	public void deleteNewObjective(long id);
	
	public void modifyNewObjective(NewObjectiveVo newObjectiveVo);
	
	public List<NewObjectiveVo> getSubObjective(long preObjId);

}
