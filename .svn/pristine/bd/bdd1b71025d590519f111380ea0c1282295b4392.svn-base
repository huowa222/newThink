package com.lenovo.newThink.controller;

import java.util.ArrayList;
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

import com.lenovo.newThink.service.UserCommentService;
import com.lenovo.newThink.service.UserFriendService;
import com.lenovo.newThink.service.UserThinkingService;
import com.lenovo.newThink.vo.UserCommentVo;
import com.lenovo.newThink.vo.UserFriendVo;
import com.lenovo.newThink.vo.UserNewIdeaVo;

@Controller
public class UserFriendController {
	@Autowired
	UserFriendService userFriendService;
	@Autowired
	UserThinkingService userThinkingService;
	@Autowired
	UserCommentService userCommentService;

	@RequestMapping(value = "/userFriend.action", params = "m=list")
	public String userFriendList(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		List<List<UserNewIdeaVo>> userFriendThinkList = new ArrayList<List<UserNewIdeaVo>>();
		HttpSession session = request.getSession();
		long userId = Long.parseLong(session.getAttribute("userid").toString());
		List<UserFriendVo> userFriendList = userFriendService
				.showUserFriendList(userId);
		List<UserNewIdeaVo> _userThinkList = null;
		if (userFriendList != null) {
			for (UserFriendVo it : userFriendList) {
				_userThinkList = userThinkingService.showUserThinkByUserId(it
						.getFriendId());

				if (_userThinkList != null) {
					List<UserNewIdeaVo> userThinkList = new ArrayList<UserNewIdeaVo>();
					for (UserNewIdeaVo think : _userThinkList) {
						if (think.getIsPost() == 1)
							userThinkList.add(think);
					}
					userFriendThinkList.add(userThinkList);
				}
			}
		}
		model.addAttribute("userId", userId);
		model.addAttribute("userFriendList", userFriendList);
		model.addAttribute("userFriendThinkList", userFriendThinkList);
		return "userFriendList.jsp";
	}

	/*
	 * @RequestMapping(value = "/userThink.action", params = "m=modify") public
	 * String userThinkModify(ModelMap model, HttpServletRequest request,
	 * HttpServletResponse response) { String userId
	 * =request.getParameter("userId"); long id =
	 * Long.parseLong(request.getParameter("id")); UserFriendVo userFriendVo =
	 * userFriendService.modifyUserFriendVo(userFriendVo);
	 * model.addAttribute("UserFriendVo", userFriendVo);
	 * model.addAttribute("userId", userId); return "newThinkEdit.jsp"; }
	 */
	@RequestMapping(value = "/userFriend.action", params = "m=delete")
	public String userThinkDelete(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		userFriendService.deleteUserFriendVo(id);
		Random r = new Random();
		return "redirect:userFriend.action?m=list&" + r.nextInt();
	}

	@RequestMapping(value = "/userFriend.action", params = "m=add")
	public String userThinkAdd(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		long userId = Long.parseLong(session.getAttribute("userid").toString());
		UserFriendVo userFriendVo = new UserFriendVo();
		userFriendVo.setUserid(userId);
		model.addAttribute("userFriendVo", userFriendVo);
		return "userFriendEdit.jsp";
	}

	@RequestMapping(value = "/userFriend.action", params = "m=save", method = RequestMethod.POST)
	public String userThinkSave(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, UserFriendVo userFriendVo) {
		/*
		 * long userId = Long.parseLong(request.getParameter("userid")); long
		 * friendId = Long.parseLong(request.getParameter("friendId"));
		 * userFriendVo.setUserid(userId); userFriendVo.setFriendId(friendId);
		 */
		if (userFriendVo.getId() == 0) {
			userFriendService.insertUserFriendVo(userFriendVo);
		} else {
			userFriendService.modifyUserFriendVo(userFriendVo);
		}
		Random r = new Random();
		return "redirect:userFriend.action?m=list&" + r.nextInt();
	}

	@RequestMapping(value = "/userThinkAndComment.action", params = "m=list")
	public String userThinkAndCommentList(ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		List<List<UserNewIdeaVo>> userFriendThinkList = new ArrayList<List<UserNewIdeaVo>>();
		HttpSession session = request.getSession();
		long userId = Long.parseLong(session.getAttribute("userid").toString());
		List<UserFriendVo> userFriendList = userFriendService
				.showUserFriendList(userId);
		List<UserNewIdeaVo> _userThinkList = null;
		if (userFriendList != null) {
			for (UserFriendVo it : userFriendList) {
				_userThinkList = userThinkingService.showUserThinkByUserId(it
						.getFriendId());

				if (_userThinkList != null) {
					List<UserNewIdeaVo> userThinkList = new ArrayList<UserNewIdeaVo>();
					for (UserNewIdeaVo think : _userThinkList) {
						if (think.getIsPost() == 1)
							userThinkList.add(think);
					}
					userFriendThinkList.add(userThinkList);
				}
			}
		}
		model.addAttribute("userId", userId);
		model.addAttribute("userFriendList", userFriendList);
		model.addAttribute("userFriendThinkList", userFriendThinkList);
		return "userFriendList.jsp";
	}

	@RequestMapping(value = "/userThinkAndComment.action", params = "m=comment")
	@ResponseBody
	public List<UserCommentVo> newThinkCommentList(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		long newThinkId = Long.parseLong(request.getParameter("thinkId"));
		List<UserCommentVo> list = new ArrayList<UserCommentVo>();
		List<UserCommentVo> userCommentList = null;
        userCommentList= userCommentService.showCommentByThinkId(newThinkId);
		for(UserCommentVo userCommentVo:userCommentList)
			list.add(userCommentVo);
		return list;
	}
	
	@RequestMapping(value = "/userThinkAndComment.action", params = "m=addComment")
	@ResponseBody
	public String addComment(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		long newThinkId = Long.parseLong(request.getParameter("newThinkId"));
		long userid = Long.parseLong(request.getSession().getAttribute("userid").toString());
		String content = request.getParameter("content");
		
		UserCommentVo userCommentVo = new UserCommentVo();
		userCommentVo.setContent(content);
		userCommentVo.setNewThinkId(newThinkId);
		userCommentVo.setUserid(userid);
		
		userCommentService.insertUserComment(userCommentVo);
		return String.valueOf(userid);
	}
}
