package com.lenovo.newThink.service;

import java.util.List;

import com.lenovo.newThink.vo.UserFriendVo;

public interface UserFriendService {
	public List<UserFriendVo> showUserFriendList(long userId);

	public void insertUserFriendVo(UserFriendVo userFriendVo);

	public void modifyUserFriendVo(UserFriendVo userFriendVo);
	
	public void deleteUserFriendVo(long id);

}
