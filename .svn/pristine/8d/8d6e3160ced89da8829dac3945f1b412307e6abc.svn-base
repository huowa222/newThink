package com.lenovo.newThink.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lenovo.newThink.dao.UserCommentMapper;
import com.lenovo.newThink.vo.UserCommentVo;

@Component("userCommentDao") 
public class UserCommentDao implements UserCommentMapper{

	@Autowired
	private UserCommentMapper userCommentMapper;

	public void insertUserComment(UserCommentVo userCommentVo) {
		// TODO Auto-generated method stub
		userCommentMapper.insertUserComment(userCommentVo);
	}

	public void updateUserComment(UserCommentVo userCommentVo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUserComment(long id) {
		// TODO Auto-generated method stub
		
	}

	public List<UserCommentVo> getUserCommentByThinkId(long thinkId) {
		// TODO Auto-generated method stub
		return userCommentMapper.getUserCommentByThinkId(thinkId);
	}

}
