package com.lenovo.newThink.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lenovo.newThink.dao.UserInfoMapper;
import com.lenovo.newThink.vo.UserInfoVo;

@Component("userInfoDao")
public class UserInfoDao implements UserInfoMapper {
	static final Logger logger = Logger.getLogger(UserInfoMapper.class);

	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfoVo getUserInfo(long userid) {
		return userInfoMapper.getUserInfo(userid);
	}

	public void insertUserInfo(UserInfoVo userInfoVo) {
		userInfoMapper.insertUserInfo(userInfoVo);
	}

	public void updateUserInfo(UserInfoVo userInfo) {
		// TODO Auto-generated method stub
		userInfoMapper.updateUserInfo(userInfo);
	}
	
	
}
