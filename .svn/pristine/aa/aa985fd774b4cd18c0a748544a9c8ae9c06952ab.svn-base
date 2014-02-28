package com.lenovo.newThink.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lenovo.newThink.dao.UserInfoMapper;
import com.lenovo.newThink.service.UserInfoService;
import com.lenovo.newThink.vo.UserInfoVo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoMapper userInfoDao;

	public UserInfoVo getUserInfo(long userid) {

		UserInfoVo user = ((UserInfoMapper) userInfoDao).getUserInfo(userid);
		if(user==null){
			user = new UserInfoVo();
			user.setUserId(userid);
		}
		return user;
	}
	
	public void insertUserInfo(long userid, String password)
	{
		UserInfoVo userInfoVo = new UserInfoVo();
		userInfoVo.setId(0);
		userInfoVo.setPassword(password);
		userInfoVo.setUserId(userid);
		userInfoDao.insertUserInfo(userInfoVo);
	}

	public void modifyUserInfo(UserInfoVo userInfoVo) {
		// TODO Auto-generated method stub
		userInfoDao.updateUserInfo(userInfoVo);
	}
}
