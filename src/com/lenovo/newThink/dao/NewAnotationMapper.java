package com.lenovo.newThink.dao;

import java.util.List;
import org.apache.log4j.Logger;
import com.lenovo.newThink.vo.NewAnotationVo;


public interface NewAnotationMapper {
	static final Logger logger = Logger.getLogger(NewAnotationMapper.class);

	public NewAnotationVo getNewAnotation(long id);
	
	public List<NewAnotationVo> getNewAnotationList();
	
	public List<NewAnotationVo> getNewAnotationById(long id);
	
	public void insertNewAnotation(NewAnotationVo newAnotationVo);
	
	public void deleteNewAnotation(long id);
	
	public void modifyNewAnotation(NewAnotationVo newAnotationVo);


}
