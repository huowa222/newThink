package com.lenovo.newThink.dao;

import java.util.List;

import org.apache.log4j.Logger;
import com.lenovo.newThink.vo.UserNewIdeaVo;

public interface UserThinkingMapper {
	static final Logger logger = Logger.getLogger(UserThinkingMapper.class);

	public UserNewIdeaVo getUserThink(long newIdeaid);
	
	public List<UserNewIdeaVo> getUserThinkList();
	
	public List<UserNewIdeaVo> getUserThinkListByUserId(long userId);
	
	public void insertUserThink(UserNewIdeaVo userNewIdeaVo);
	
	public void deleteUserThink(long newIdeaid);
	
	public void modifyUserThink(UserNewIdeaVo userNewIdeaVo);
	
	public void changePostStatus(long isPost, long id);

	public void changePosition_x(long x);
	
	public void changePosition_y(long y);
	
}

