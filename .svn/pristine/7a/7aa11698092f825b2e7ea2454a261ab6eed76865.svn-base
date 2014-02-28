package com.lenovo.newThink.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lenovo.newThink.dao.UserFriendMapper;
import com.lenovo.newThink.vo.UserFriendVo;

@Component("userFriendDao") 
public class UserFriendDao implements UserFriendMapper {
	@Autowired
	private UserFriendMapper userFriendMapper;

	public List<UserFriendVo> getUserFriendByUserId(long userid) {
		// TODO Auto-generated method stub
		return userFriendMapper.getUserFriendByUserId(userid);
	}

	public void insertUserFriend(UserFriendVo userFriendVo) {
		// TODO Auto-generated method stub
		userFriendMapper.insertUserFriend(userFriendVo);
	}

	public void updateUserFriend(UserFriendVo userFriendVo) {
		// TODO Auto-generated method stub
		userFriendMapper.updateUserFriend(userFriendVo);
	}

	public void deleteUserFriend(long id) {
		// TODO Auto-generated method stub
		userFriendMapper.deleteUserFriend(id);
	}
	

}
