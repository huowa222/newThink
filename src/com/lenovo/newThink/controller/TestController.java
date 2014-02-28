package com.lenovo.newThink.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lenovo.newThink.vo.UserNewIdeaVo;

@Controller
public class TestController extends NewThinkController {

	@RequestMapping(value = "/test.action", params = "m=test")
	public @ResponseBody List<String> userThinkList(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String str = "test???";
		String str1 = "i fuck you";
		List<String> list = new ArrayList<String>();
		list.add(str);
		list.add(str1);
		return list;
	}
	
	@RequestMapping(value = "/test.action", params = "m=test1")
	public @ResponseBody ModelMap userThinkList1(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String str = "test???";
		String str1 = "i fuck you";
		List<String> list = new ArrayList<String>();
		list.add(str);
		list.add(str1);
        model.addAttribute("list", list);
		return model;
	}
	
	@RequestMapping(value = "/test.action", params = "m=test2")
	public @ResponseBody List<String> userThinkList2(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String str = "test???";
		String str1 = "i fuck you";

		List<String> list = new ArrayList<String>();
		list.add(str);
		list.add(str1);
        model.addAttribute("list", list);
		return list;
	}
	
	@RequestMapping(value = "/test.action", params = "m=test3")
	public @ResponseBody List<String> userThinkList3(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String str = "test???";
		String str1 = "i fuck you333";

		List<String> list = new ArrayList<String>();
		list.add(str);
		list.add(str1);
		//JSONObject jsonObj = new JSONObject();
		JSONObject jsonObj = JSONObject.fromObject(list);
		System.out.println(jsonObj.toString());
        //model.addAttribute("list", jsonObj.toString());
		return list;
	}
	
	
	@RequestMapping(value = "/test.action", params = "m=test5")
	@ResponseBody
	public List<UserNewIdeaVo> userThinkList5(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		//String str = "{\"d\": [{\"name\":\"cz\",\"ag\":30},{\"name\":\"lzl\",\"ag\":25},{\"name\":\"wl\",\"ag\":28}]}";
		//String str = request.getParameter("thinkId");
		
		List<UserNewIdeaVo> list = new ArrayList<UserNewIdeaVo>();
		UserNewIdeaVo userNewIdeaVo = null;
		for(int i=0; i<3; i++)
		{
			userNewIdeaVo = new UserNewIdeaVo();
			if(i==1)
			userNewIdeaVo.setContent("日");
			else
				userNewIdeaVo.setContent("你妈");
			list.add(userNewIdeaVo);
		}
		return list;
	}
}