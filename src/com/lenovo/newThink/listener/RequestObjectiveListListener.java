package com.lenovo.newThink.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestObjectiveListListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		HttpServletRequest  request1 = (HttpServletRequest) event.getServletRequest();
		String str = request1.getRequestURI();
		
		if(str.contains("newThinkManage.action?m=add"))
		{
			
		}else if(str.contains("newThinkManage.action?m=delete"))
		{
			
		}
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
