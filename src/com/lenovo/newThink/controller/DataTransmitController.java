package com.lenovo.newThink.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lenovo.lps.ukitool.*;

@Controller
public class DataTransmitController {

	@RequestMapping(value = "/dataTransmit.action", params = "m=start")
	public String userFriendList(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		long userId = Long.parseLong(session.getAttribute("userid").toString());
		
		ImportStoreData.startImportData();
		model.addAttribute("userId", userId);
		return "dataTransmit.jsp";
	}
}
