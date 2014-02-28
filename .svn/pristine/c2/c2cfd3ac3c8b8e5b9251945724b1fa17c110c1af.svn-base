package com.lenovo.newThink.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenovo.newThink.dao.impl.UserFriendDao;
import com.lenovo.newThink.service.UserFriendService;
import com.lenovo.newThink.vo.UserFriendVo;

@Service
public class UserFriendServiceImpl implements UserFriendService{

	@Autowired
	private UserFriendDao userFriendDao;
	
	public List<UserFriendVo> showUserFriendList(long userId) {
		// TODO Auto-generated method stub
		return userFriendDao.getUserFriendByUserId(userId);
	}

	public void insertUserFriendVo(UserFriendVo userFriendVo) {
		// TODO Auto-generated method stub
		userFriendDao.insertUserFriend(userFriendVo);
	}

	public void modifyUserFriendVo(UserFriendVo userFriendVo) {
		// TODO Auto-generated method stub
		userFriendDao.updateUserFriend(userFriendVo);
	}

	public void deleteUserFriendVo(long id) {
		// TODO Auto-generated method stub
		userFriendDao.deleteUserFriend(id);
	}

}
