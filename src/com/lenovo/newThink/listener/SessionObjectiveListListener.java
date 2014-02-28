package com.lenovo.newThink.listener;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.lenovo.newThink.service.UserThinkingService;
import com.lenovo.newThink.vo.UserNewIdeaVo;

public class SessionObjectiveListListener implements HttpSessionListener {

	@Autowired
	UserThinkingService userThinkingService;
	
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		HttpSession session = event.getSession();
		long userid =0;
		if(session.getAttribute("userid")!=null)
	    userid = Long.parseLong(session.getAttribute("userid").toString());
		List<UserNewIdeaVo> userThinkList = userThinkingService.showUserThinkByUserId(userid);
		session.setAttribute("userThinkList", userThinkList);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
