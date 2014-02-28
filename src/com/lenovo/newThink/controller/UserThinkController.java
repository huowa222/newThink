package com.lenovo.newThink.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.lenovo.newThink.service.UserThinkingService;
import com.lenovo.newThink.vo.UserNewIdeaVo;
import com.lenovo.newThink.util.*;

@Controller
public class UserThinkController extends NewThinkController {

	@Autowired
	UserThinkingService userThinkingService;

	@RequestMapping(value = "/userThink.action", params = "m=list")
	public String userThinkList(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
        //long userId =Long.parseLong(request.getParameter("userId"));
		HttpSession session = request.getSession();
		long userId = Long.parseLong(session.getAttribute("userid").toString());
		List<UserNewIdeaVo> ThinkList = userThinkingService.showUserThinkByUserId(userId);
		model.addAttribute("ThinkList", ThinkList);
        model.addAttribute("userId", userId);
		return "newThinkList.jsp";
	}

	@RequestMapping(value = "/userThink.action", params = "m=modify")
	public String userThinkModify(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String userId =request.getParameter("userId");
		long id = Long.parseLong(request.getParameter("id"));
		UserNewIdeaVo userNewIdeaVo = userThinkingService.getUserThinkByid(id);
		model.addAttribute("userThink", userNewIdeaVo);
		model.addAttribute("userId", userId);
		return "newThinkEdit.jsp";
	}
	
	@RequestMapping(value = "/userThink.action", params = "m=post")
	public String userThinkPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String userId =request.getParameter("userId");
		long id = Long.parseLong(request.getParameter("id"));
		long isPost = Long.parseLong(request.getParameter("isPost"));
		UserNewIdeaVo userNewIdeaVo = userThinkingService.getUserThinkByid(id);
		if(isPost==1)
			userNewIdeaVo.setIsPost(0);
		else
			userNewIdeaVo.setIsPost(1);
		userThinkingService.modifyUserThink(userNewIdeaVo);
		model.addAttribute("userId", userId);
		Random r = new Random();
		return "redirect:userThink.action?m=list&userId="+userId+"&"+r.nextInt();
	}

	@RequestMapping(value = "/userThink.action", params = "m=delete")
	public String userThinkDelete(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
        String userId = request.getParameter("userId");   
		long id = Long.parseLong(request.getParameter("id"));
		userThinkingService.deleteUserThink(id);
		Random r = new Random();
		return "redirect:userThink.action?m=list&userId="+userId+"&"+r.nextInt();
	}

	@RequestMapping(value = "/userThink.action", params = "m=add")
	public String userThinkAdd(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
        String userId =request.getParameter("userId");
		UserNewIdeaVo userNewIdeaVo = new UserNewIdeaVo();
		userNewIdeaVo.setUserId(Long.parseLong(userId));
		userNewIdeaVo.setPosition_x(100);
		userNewIdeaVo.setPosition_y(100);
		model.addAttribute("userThink", userNewIdeaVo);
		model.addAttribute("userId", userId);
		return "newThinkEdit.jsp";
	}

	@RequestMapping(value = "/userThink.action", params = "m=save", method = RequestMethod.POST)
	public String userThinkSave(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, UserNewIdeaVo userNewIdeaVo) {
		String userId = request.getParameter("userId");
		String color = userNewIdeaVo.getColor().replaceAll(",", "");//我真他妈的觉得web有问题，操你妈，为什么得这样？
		userNewIdeaVo.setColor(color);
		if (userNewIdeaVo.getId() == 0) {
			userThinkingService.addUserThink(userNewIdeaVo);
		} else {
			userThinkingService.modifyUserThink(userNewIdeaVo);
		}
		Random r = new Random();
		return "redirect:userThink.action?m=list&userId="+userId+"&"+r.nextInt();
	}
	
	@RequestMapping(value = "/userThink.action", params = "m=uploadPics", method = RequestMethod.POST)
	public String uploadPics(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {		
		String picUrl = UploadFileUtil.saveUploadFile(request,"pics");
		
		UserNewIdeaVo userNewIdeaVo = new UserNewIdeaVo();
		userNewIdeaVo.setContent(request.getParameter("content"));
		userNewIdeaVo.setColor(request.getParameter("color"));
		userNewIdeaVo.setId(Long.parseLong(request.getParameter("id")));
		userNewIdeaVo.setPosition_x(Long.parseLong(request.getParameter("position_x")));
		userNewIdeaVo.setPosition_y(Long.parseLong(request.getParameter("position_y")));
		userNewIdeaVo.setPicUrl(picUrl);
		userNewIdeaVo.setUserId(Long.parseLong(request.getParameter("userId")));//新想法对象并没有存到数据库，再次返回编辑界面
		model.addAttribute("userThink", userNewIdeaVo);
		model.addAttribute("userId", request.getParameter("userId"));
		return "newThinkEdit.jsp";
	}

	@RequestMapping(value = "/userThink.action", params = "m=changePosition")
	@ResponseBody
	public String changePosition(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		long thinkId = Long.parseLong(request.getParameter("thinkId"));
		String x =request.getParameter("x");
		String y =request.getParameter("y");
		long position_x = Long.parseLong(x.substring(0, x.indexOf("p")));
		long position_y = Long.parseLong(y.substring(0, y.indexOf("p")));
		
		UserNewIdeaVo userNewIdeaVo = userThinkingService.getNewThinkById(thinkId);
		userNewIdeaVo.setPosition_x(position_x);
		userNewIdeaVo.setPosition_y(position_y);
		
	    userThinkingService.modifyUserThink(userNewIdeaVo);
		return "success";
	}
}