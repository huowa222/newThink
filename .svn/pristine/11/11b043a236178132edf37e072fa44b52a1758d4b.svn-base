package com.lenovo.newThink.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lenovo.newThink.dao.UserCommentMapper;
import com.lenovo.newThink.service.UserCommentService;
import com.lenovo.newThink.vo.UserCommentVo;

@Service
public class UserCommentServiceImpl implements UserCommentService {

	@Autowired
	@Qualifier("userCommentDao")
	private UserCommentMapper userCommentDao;
	
	public void insertUserComment(UserCommentVo userCommentVo) {
		// TODO Auto-generated method stub
		userCommentDao.insertUserComment(userCommentVo);
	}

	public List<UserCommentVo> showCommentByThinkId(long newThinkId) {
		// TODO Auto-generated method stub
		return userCommentDao.getUserCommentByThinkId(newThinkId);
	}

}
