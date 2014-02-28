package com.lenovo.newThink.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lenovo.newThink.service.UserCommentService;

@Controller
public class UserCommentController {

	@Autowired
	UserCommentService userThinkingService;

	@RequestMapping(value = "/userComment.action", params = "m=list")
	public String userThinkList(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
        //long userId =Long.parseLong(request.getParameter("userId"));
		HttpSession session = request.getSession();
		long userId = Long.parseLong(session.getAttribute("userid").toString());
		//List<UserNewIdeaVo> ThinkList = userThinkingService.showUserThinkByUserId(userId);
		//model.addAttribute("ThinkList", ThinkList);
        model.addAttribute("userId", userId);
		return "newThinkList.jsp";
	}
}
