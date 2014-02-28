package com.lenovo.newThink.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lenovo.newThink.dao.NewAnotationMapper;
import com.lenovo.newThink.dao.NewInspirationMapper;
import com.lenovo.newThink.dao.NewObjectiveMapper;
import com.lenovo.newThink.service.NewThinkManageService;
import com.lenovo.newThink.vo.NewAnotationVo;
import com.lenovo.newThink.vo.NewInspirationVo;
import com.lenovo.newThink.vo.NewObjectiveVo;

@Service
public class NewThinkManageServiceImpl implements NewThinkManageService {

	@Autowired
	@Qualifier("newAnotationDao")
	private NewAnotationMapper newAnotationDao;

	@Autowired
	@Qualifier("newInspirationDao")
	private NewInspirationMapper newInspirationDao;

	@Autowired
	@Qualifier("newObjectiveDao")
	private NewObjectiveMapper newObjectiveDao;

	public void addNewInspiration(NewInspirationVo newInspirationVo) {
		// TODO Auto-generated method stub
		newInspirationDao.insertNewInspiration(newInspirationVo);
	}

	public void deleteNewInspiration(long id) {
		// TODO Auto-generated method stub
		newInspirationDao.deleteNewInspiration(id);
	}

	public List<NewInspirationVo> showNewInspirationList() {
		// TODO Auto-generated method stub
		return newInspirationDao.getNewInspirationList();
	}

	public NewInspirationVo getNewInspiration(long id) {
		// TODO Auto-generated method stub
		return newInspirationDao.getNewInspiration(id);
	}

	public void modifyInspriation(NewInspirationVo newInspirationVo) {
		// TODO Auto-generated method stub
		newInspirationDao.modifyNewInspiration(newInspirationVo);
	}

	public List<NewInspirationVo> showNewInspirationbyId(long id) {
		// TODO Auto-generated method stub
		return newInspirationDao.getNewInspirationById(id);
	}

	public void addNewObjective(NewObjectiveVo newObjectiveVo) {
		// TODO Auto-generated method stub
		newObjectiveDao.insertNewObjective(newObjectiveVo);
	}

	public void deleteNewObjective(long id) {
		// TODO Auto-generated method stub
		newObjectiveDao.deleteNewObjective(id);
	}

	public List<NewObjectiveVo> showNewObjectiveList() {
		// TODO Auto-generated method stub
		return newObjectiveDao.getNewObjectiveList();
	}

	public NewObjectiveVo getNewObjective(long id) {
		// TODO Auto-generated method stub
		return newObjectiveDao.getNewObjective(id);
	}

	public void modifyNewObjective(NewObjectiveVo newObjectiveVo) {
		// TODO Auto-generated method stub
		newObjectiveDao.modifyNewObjective(newObjectiveVo);
	}

	public List<NewObjectiveVo> showNewObjectiveById(long id) {
		// TODO Auto-generated method stub
		return newObjectiveDao.getNewObjectiveById(id);
	}
	
	public List<NewObjectiveVo> showSubObjective(long preObjId) {
		// TODO Auto-generated method stub
		return newObjectiveDao.getSubObjective(preObjId);
	}
	

	public void addNewAnotation(NewAnotationVo newAnotationVo) {
		// TODO Auto-generated method stub
		newAnotationDao.insertNewAnotation(newAnotationVo);
	}

	public void deleteNewAnotation(long id) {
		// TODO Auto-generated method stub
		newAnotationDao.deleteNewAnotation(id);
	}

	public List<NewAnotationVo> showNewAnotationList() {
		// TODO Auto-generated method stub
		return newAnotationDao.getNewAnotationList();
	}

	public NewAnotationVo getNewAnotation(long id) {
		// TODO Auto-generated method stub
		return newAnotationDao.getNewAnotation(id);
	}

	public void modifyNewAnotation(NewAnotationVo newAnotationVo) {
		// TODO Auto-generated method stub
		newAnotationDao.modifyNewAnotation(newAnotationVo);
	}

	public List<NewAnotationVo> showNewAnotationById(long id) {
		// TODO Auto-generated method stub
		return newAnotationDao.getNewAnotationById(id);
	}

}
