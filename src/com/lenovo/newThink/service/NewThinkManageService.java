package com.lenovo.newThink.service;

import java.util.List;

import com.lenovo.newThink.vo.NewObjectiveVo;
import com.lenovo.newThink.vo.NewAnotationVo;
import com.lenovo.newThink.vo.NewInspirationVo;

public interface NewThinkManageService {

	public void addNewInspiration(NewInspirationVo newInspirationVo);

	public void deleteNewInspiration(long id);

	public List<NewInspirationVo> showNewInspirationList();

	public NewInspirationVo getNewInspiration(long id);

	public void modifyInspriation(NewInspirationVo newInspirationVo);
	
	public List<NewInspirationVo> showNewInspirationbyId(long id);
	
	
	public void addNewObjective(NewObjectiveVo NewObjectiveVo);

	public void deleteNewObjective(long id);

	public List<NewObjectiveVo> showNewObjectiveList();

	public NewObjectiveVo getNewObjective(long id);

	public void modifyNewObjective(NewObjectiveVo NewObjectiveVo);
	
	public List<NewObjectiveVo> showNewObjectiveById(long id);
	
	public List<NewObjectiveVo> showSubObjective(long preObjId);
	
	
	public void addNewAnotation(NewAnotationVo newAnotationVo);

	public void deleteNewAnotation(long id);

	public List<NewAnotationVo> showNewAnotationList();

	public NewAnotationVo getNewAnotation(long id);

	public void modifyNewAnotation(NewAnotationVo newAnotationVo);
	
	public List<NewAnotationVo> showNewAnotationById(long id);
	

}