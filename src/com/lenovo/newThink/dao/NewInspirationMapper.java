package com.lenovo.newThink.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.lenovo.newThink.vo.NewInspirationVo;

public interface NewInspirationMapper {
	static final Logger logger = Logger.getLogger(NewInspirationMapper.class);

	public NewInspirationVo getNewInspiration(long id);
	
	public List<NewInspirationVo> getNewInspirationList();
	
	public List<NewInspirationVo> getNewInspirationById(long id); 
	
	public void insertNewInspiration(NewInspirationVo newInspirationVo);
	
	public void deleteNewInspiration(long id);
	
	public void modifyNewInspiration(NewInspirationVo newInspirationVo);

}
