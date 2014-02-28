package com.lenovo.newThink.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lenovo.newThink.dao.UserThinkingMapper;
import com.lenovo.newThink.service.UserThinkingService;
import com.lenovo.newThink.vo.UserNewIdeaVo;

@Service
public class UserThinkingServiceImpl implements UserThinkingService {
	@Autowired
	@Qualifier("userThinkingDao")
	private UserThinkingMapper userThinkingDao;

	public void addUserThink(UserNewIdeaVo userNewIdeaVo) {
		// TODO Auto-generated method stub
		userThinkingDao.insertUserThink(userNewIdeaVo);
	}

	public void deleteUserThink(long id) {
		// TODO Auto-generated method stub
		userThinkingDao.deleteUserThink(id);
	}

	public List<UserNewIdeaVo> showUserThink() {
		// TODO Auto-generated method stub
		List<UserNewIdeaVo> userThinkList = userThinkingDao.getUserThinkList();
		return userThinkList;
	}

	public UserNewIdeaVo getUserThinkByid(long newIdeaid) {
		// TODO Auto-generated method stub
		UserNewIdeaVo userNewIdeaVo = userThinkingDao.getUserThink(newIdeaid);
		return userNewIdeaVo;
	}

	public void modifyUserThink(UserNewIdeaVo userNewIdeaVo) {
		// TODO Auto-generated method stub
		userThinkingDao.modifyUserThink(userNewIdeaVo);
	}

	public List<UserNewIdeaVo> showUserThinkByUserId(long userId) {
		// TODO Auto-generated method stub
		return userThinkingDao.getUserThinkListByUserId(userId);
	}

	public UserNewIdeaVo getNewThinkById(long newIdeaid) {
		// TODO Auto-generated method stub
		return userThinkingDao.getUserThink(newIdeaid);
	}

	public void changePostStatus(long isPost,long id) {
		// TODO Auto-generated method stub
		userThinkingDao.changePostStatus(isPost,id);
	}

	public void changePosition(long x, long y) {
		// TODO Auto-generated method stub
		userThinkingDao.changePosition_x(x);
		userThinkingDao.changePosition_y(y);
	}

}
