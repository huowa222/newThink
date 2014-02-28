package com.lenovo.newThink.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lenovo.newThink.dao.UserThinkingMapper;
import com.lenovo.newThink.vo.UserNewIdeaVo;

@Component("userThinkingDao")
public class UserThinkingDao implements UserThinkingMapper {
	static final Logger logger = Logger.getLogger(UserThinkingMapper.class);
	
	@Autowired
	private UserThinkingMapper userThinkingMapper;

	public void insertUserThink(UserNewIdeaVo userNewIdeaVo) {
		// TODO Auto-generated method stub
		userThinkingMapper.insertUserThink(userNewIdeaVo);
	}

	public void deleteUserThink(long newIdeaid) {
		// TODO Auto-generated method stub
		userThinkingMapper.deleteUserThink(newIdeaid);
	}

	public void modifyUserThink(UserNewIdeaVo userNewIdeaVo) {
		// TODO Auto-generated method stub
		userThinkingMapper.modifyUserThink(userNewIdeaVo);
	}

	public UserNewIdeaVo getUserThink(long newIdeaid) {
		// TODO Auto-generated method stub
		UserNewIdeaVo userNewIdeaVo = userThinkingMapper.getUserThink(newIdeaid);
		return userNewIdeaVo;
	}

	public List<UserNewIdeaVo> getUserThinkList() {
		// TODO Auto-generated method stub
		return userThinkingMapper.getUserThinkList();
	}

	public List<UserNewIdeaVo> getUserThinkListByUserId(long userId) {
		// TODO Auto-generated method stub
		return userThinkingMapper.getUserThinkListByUserId(userId);
	}

	public void changePostStatus(long isPost,long id) {
		// TODO Auto-generated method stub
		userThinkingMapper.changePostStatus(isPost,id);
	}

	public void changePosition_x(long x) {
		// TODO Auto-generated method stub
		userThinkingMapper.changePosition_x(x);
	}

	public void changePosition_y(long y) {
		// TODO Auto-generated method stub
		userThinkingMapper.changePosition_y(y);
	}
	
}
	
