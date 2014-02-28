package com.lenovo.newThink.service;

import com.lenovo.newThink.vo.UserInfoVo;

public interface UserInfoService {
	public UserInfoVo getUserInfo(long userId);
	
	public void insertUserInfo(long userid, String password);

	public void modifyUserInfo(UserInfoVo userInfoVo);
}
