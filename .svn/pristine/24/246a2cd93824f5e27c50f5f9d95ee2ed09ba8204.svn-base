package com.lenovo.newThink.controller;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lenovo.newThink.vo.*;
import com.lenovo.newThink.service.impl.UserInfoServiceImpl;

@Controller
public class UserController extends NewThinkController {
	// final static Log log = Log.getInstance(LoginController.class);
	// private static BusinessLog bizLog=new BusinessLog(LoginController.class);

	@Autowired
	private UserInfoServiceImpl userInfoService;

	@RequestMapping(value = "/user.action", params = "m=login", method = RequestMethod.POST)
	public String loginVerify(HttpServletRequest request,
			HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String cookieStatus = request.getParameter("cookie");

		HttpSession session = request.getSession();// put it into session
		session.setAttribute("userid", userid);

		if (userid == null || userid.trim().length() == 0 || password == null
				|| password.trim().length() == 0) {
			return "error.jsp";
		}

		UserInfoVo userInfoVo = userInfoService.getUserInfo(Long
				.parseLong(userid));
		if (userInfoVo == null) {
			return "error.jsp";
		} else {
			String pwd = userInfoVo.getPassword();
			if (pwd == null)
				return "error.jsp";
			else if (pwd.equals(password.trim())) {
				if (cookieStatus.equals("yes")) {
					Cookie cookie1 = new Cookie("userid", userid);// put the
					// username and
					// password to
					// cookie
					Cookie cookie2 = new Cookie("password", password);
					cookie1.setMaxAge(365 * 24 * 3600);
					cookie1.setPath("/");
					response.addCookie(cookie1);
					cookie2.setMaxAge(365 * 24 * 3600);
					cookie2.setPath("/");
					response.addCookie(cookie2);
				} else {
					Cookie useridCookie = new Cookie("userid", null);
					Cookie passwordCookie = new Cookie("password", null);
					useridCookie.setMaxAge(0);// 删除该Cookie
					useridCookie.setPath("/");
					passwordCookie.setMaxAge(0);
					passwordCookie.setPath("/");
					response.addCookie(useridCookie);
					response.addCookie(passwordCookie);

				}

				Random r = new Random();
				return "redirect:userThink.action?m=list&userId=" + userid
						+ "&" + r.nextInt(1000);
			} else
				return "error.jsp";
		}

	}

	@RequestMapping(value = "/user.action", params = "m=register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,
			HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		if (userid == null || userid.trim().length() == 0 || password == null
				|| password.trim().length() == 0) {
			return "error.jsp";
		}

		UserInfoVo userInfoVo = userInfoService.getUserInfo(Long
				.parseLong(userid));
		if (userInfoVo.getId() != 0) {
			return "error.jsp";
		} else {
			userInfoService.insertUserInfo(Long.parseLong(userid), password);
			return "success.jsp";
		}
	}

	@RequestMapping(value = "/user.action", params = "m=modify", method = RequestMethod.GET)
	public String modifyPassword(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		long userid = Long.parseLong(session.getAttribute("userid").toString());
		UserInfoVo userInfoVo = userInfoService.getUserInfo(userid);

		model.addAttribute("userInfoVo", userInfoVo);
		return "passwordModify.jsp";
	}

	@RequestMapping(value = "/user.action", params = "m=save", method = RequestMethod.POST)
	public String save(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String password = request.getParameter("password");
		// String userid = request.getParameter("userid");
		HttpSession session = request.getSession();
		long userId = Long.parseLong(session.getAttribute("userid").toString());

		UserInfoVo userInfoVo = new UserInfoVo();
		userInfoVo.setUserId(userId);
		userInfoVo.setPassword(password);
		userInfoService.modifyUserInfo(userInfoVo);
		model.addAttribute("userInfoVo", userInfoVo);
		Random r = new Random();
		return "redirect:userThink.action?m=list&userId=" + userId + "&"
				+ r.nextInt(1000);
	}

	@RequestMapping(value = "/user.action", params = "m=client", method = RequestMethod.POST)
	@ResponseBody
	public String getSession(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();// put it into session
		String userid = (String) session.getAttribute("userid");

		return userid;
	}

	@RequestMapping(value = "/user.action", params = "m=exit")
	public String exit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();// put it into session
		session.invalidate();
		Cookie useridCookie = new Cookie("userid", null);
		Cookie passwordCookie = new Cookie("password", null);
		useridCookie.setMaxAge(0);// 删除该Cookie
		useridCookie.setPath("/");
		passwordCookie.setMaxAge(0);
		passwordCookie.setPath("/");
		response.addCookie(useridCookie);
		response.addCookie(passwordCookie);
		return "login.jsp";

	}
}
