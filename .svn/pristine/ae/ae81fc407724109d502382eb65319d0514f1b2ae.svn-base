package com.lenovo.newThink.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lenovo.newThink.service.NewThinkManageService;
import com.lenovo.newThink.service.UserThinkingService;

import com.lenovo.newThink.util.ObjectiveProcessUtil;
import com.lenovo.newThink.vo.NewAnotationVo;
import com.lenovo.newThink.vo.NewInspirationVo;
import com.lenovo.newThink.vo.NewObjectiveVo;
import com.lenovo.newThink.vo.UserCommentVo;

@Controller
public class NewThinkManageController extends NewThinkController {

	@Autowired
	NewThinkManageService newThinkManageService;

	@Autowired
	UserThinkingService userThinkingService;

	@RequestMapping(value = "/newThinkManage.action", params = "m=list")
	public String newThinkManageList(ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {

		String finishedObjFlag = request.getParameter("flag");
		long id = Long.parseLong(request.getParameter("newIdeaid"));
		String newThinkName = userThinkingService.getNewThinkById(id)
				.getContent();

		String picUrl = userThinkingService.getNewThinkById(id).getPicUrl();
		// request.getParameter("preObjId");
		List<NewInspirationVo> newInspirationVoList = newThinkManageService
				.showNewInspirationbyId(id);
		List<NewAnotationVo> newAnotationVoList = newThinkManageService// 有问题
				.showNewAnotationById(id);
		List<NewAnotationVo> aaa = newThinkManageService.showNewAnotationList();

		model.addAttribute("newInspirationVoList", newInspirationVoList);
		model.addAttribute("newAnotationVoList", aaa);
		model.addAttribute("newIdeaid", id);

		String strPreObjId = request.getParameter("preObjId");
		if (strPreObjId == null || strPreObjId.equals("")
				|| Long.parseLong(strPreObjId) == 0) {
			List<NewObjectiveVo> newObjectiveVoList = null;
			if (finishedObjFlag == null || finishedObjFlag.length()==0|| finishedObjFlag.equals("false")) {
				newObjectiveVoList = newThinkManageService
						.showNewObjectiveById(id);
			} else {
				List<NewObjectiveVo> _newObjectiveVoList = newThinkManageService
						.showNewObjectiveById(id);
				newObjectiveVoList = new ArrayList<NewObjectiveVo>();
				for (NewObjectiveVo newObjectiveVo : _newObjectiveVoList) {
					if (newObjectiveVo.getStatus().equals("true1")){
						
						newObjectiveVoList.add(newObjectiveVo);
					}					
				}
			}

			model.addAttribute("objProcessNo",
					ObjectiveProcessUtil.ObjProcessCount(newObjectiveVoList));
			model.addAttribute("newObjectiveVoList", newObjectiveVoList);

		} else {
			long preObjId = Long.parseLong(request.getParameter("preObjId"));
			List<NewObjectiveVo> newObjectiveVoList = newThinkManageService
					.showSubObjective(preObjId);
			model.addAttribute("objProcessNo",
					ObjectiveProcessUtil.ObjProcessCount(newObjectiveVoList));
			model.addAttribute("preObjId", preObjId);
			model.addAttribute("newObjectiveVoList", newObjectiveVoList);
		}
		model.addAttribute("newThinkName", newThinkName);
		model.addAttribute("picUrl", picUrl);
		model.addAttribute("flag", finishedObjFlag);
		return "thinkManageList.jsp";
	}

	@RequestMapping(value = "/newThinkManage.action", params = "m=modify")
	public String userThinkModify(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String tempt = request.getParameter("n");
		long id = Long.parseLong(request.getParameter("id"));
		// long newIdeaid = Long.parseLong(request.getParameter("newIdeaid"));

		if (tempt.equals("inspiration")) {
			NewInspirationVo newInspirationVo = newThinkManageService
					.getNewInspiration(id);
			model.addAttribute("element", newInspirationVo);
		} else if (tempt.equals("objective")) {
			NewObjectiveVo newObjectiveVo = newThinkManageService
					.getNewObjective(id);
			model.addAttribute("element", newObjectiveVo);
		} else {
			NewAnotationVo newAnotationVo = newThinkManageService
					.getNewAnotation(id);
			model.addAttribute("element", newAnotationVo);
		}
		// model.addAttribute("newIdeaid", newIdeaid);
		model.addAttribute("elementName", tempt);
		// model.addAttribute("preObjective", tempt);
		return "thinkManageEdit.jsp";
	}

	@RequestMapping(value = "/newThinkManage.action", params = "m=delete")
	public String userThinkDelete(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		String tempt = request.getParameter("n");
		long id = Long.parseLong(request.getParameter("id"));
		long newIdeaid = Long.parseLong(request.getParameter("newIdeaid"));

		if (tempt.equals("inspiration")) {
			newThinkManageService.deleteNewInspiration(id);
		} else if (tempt.equals("objective")) {
			newThinkManageService.deleteNewObjective(id);
			long preObjId = Long.parseLong(request.getParameter("preObjId"));
			model.addAttribute("preObjId", preObjId);
		} else {
			newThinkManageService.deleteNewAnotation(id);
		}
		newThinkManageService.deleteNewAnotation(id);
		Random r = new Random();
		model.addAttribute("newIdeaid", newIdeaid);
		return "redirect:newThinkManage.action?m=list&" + r.nextInt();
	}

	@RequestMapping(value = "/newThinkManage.action", params = "m=add")
	public String userThinkAdd(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		long newIdeaid = Long.parseLong(request.getParameter("newIdeaid"));
		String elementName = request.getParameter("n");
		if (elementName.equals("inspiration")) {
			NewInspirationVo newInspirationVo = new NewInspirationVo();
			newInspirationVo.setNewIdeaid(newIdeaid);
			model.addAttribute("element", newInspirationVo);
		} else if (elementName.equals("objective")) {
			NewObjectiveVo newObjectiveVo = new NewObjectiveVo();
			newObjectiveVo.setNewIdeaid(newIdeaid);
			newObjectiveVo.setStatus("false");
			String strPreObjId = request.getParameter("preObjId");
			if (strPreObjId != null && !strPreObjId.equals("")
					&& Long.parseLong(strPreObjId) != 0) {
				long a = Long.parseLong(strPreObjId);
				newObjectiveVo.setPreObjId(a);
				model.addAttribute("preObjId", a);
			} else {
				model.addAttribute("preObjId", 0);// ???
			}
			model.addAttribute("element", newObjectiveVo);

		} else {
			NewAnotationVo newAnotationVo = new NewAnotationVo();
			newAnotationVo.setNewIdeaid(newIdeaid);
			model.addAttribute("element", newAnotationVo);
		}
		model.addAttribute("elementName", elementName);
		return "thinkManageEdit.jsp";
	}

	@RequestMapping(value = "/newThinkManage.action", params = "m=save", method = RequestMethod.POST)
	public String userThinkSave(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, NewInspirationVo newInspirationVo,
			NewObjectiveVo newObjectiveVo, NewAnotationVo newAnotationVo) {
		long newIdeaid = Long.parseLong(request.getParameter("newIdeaid"));
		long id = Long.parseLong(request.getParameter("id"));

		String elementName = request.getParameter("n");
		if (elementName.equals("inspiration")) {
			if (newInspirationVo.getId() == 0) {
				newThinkManageService.addNewInspiration(newInspirationVo);
			} else {
				newThinkManageService.modifyInspriation(newInspirationVo);
			}
		} else if (elementName.equals("objective")) {
			if (newObjectiveVo.getId() == 0) {
				newThinkManageService.addNewObjective(newObjectiveVo);
			} else {
				newThinkManageService.modifyNewObjective(newObjectiveVo);
			}
		} else {
			if (newAnotationVo.getId() == 0) {
				newThinkManageService.addNewAnotation(newAnotationVo);
			} else {
				newThinkManageService.modifyNewAnotation(newAnotationVo);
			}
		}
		Random r = new Random();
		model.addAttribute("newIdeaid", newIdeaid);
		model.addAttribute("id", id);
		// long preObjId= Long.parseLong(request.getParameter("preObjId"));
		String strPreObjId = request.getParameter("preObjId");
		if (strPreObjId == null || strPreObjId.equals("")
				|| Long.parseLong(strPreObjId) == 0) {
			model.addAttribute("preObjId", 0);
		} else {
			model.addAttribute("preObjId", Long.parseLong(strPreObjId));
		}
		return "redirect:newThinkManage.action?m=list&" + r.nextInt();
	}

	@RequestMapping(value = "/newThinkManage.action", params = "m=ajax")
	public @ResponseBody
	String userThinkText(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String str = "";

		return null;
	}

	@RequestMapping(value = "/newThinkManage.action", params = "m=ObjStatus")
	public String objectiveChangeStatus(ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		long newIdeaid = Long.parseLong(request.getParameter("newIdeaid"));

		NewObjectiveVo newObjectiveVo = newThinkManageService
				.getNewObjective(id);
		if (newObjectiveVo.getStatus().equals("false"))
			newObjectiveVo.setStatus("true1");
		else
			newObjectiveVo.setStatus("false");
		newThinkManageService.modifyNewObjective(newObjectiveVo);

		String strPreObjId = request.getParameter("preObjId");
		if (strPreObjId == null || strPreObjId.equals("")
				|| Long.parseLong(strPreObjId) == 0) {
			model.addAttribute("preObjId", 0);
		} else {
			model.addAttribute("preObjId", Long.parseLong(strPreObjId));
		}
		Random r = new Random();
		model.addAttribute("newIdeaid", newIdeaid);
		return "redirect:newThinkManage.action?m=list&" + r.nextInt();
	}

	@RequestMapping(value = "/newThinkManage.action", params = "m=add_ajax")
	@ResponseBody
	public List<NewInspirationVo> userThinkAdd_ajax(ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {

		long newIdeaid = Long.parseLong(request.getParameter("newIdeaid"));
		String content = request.getParameter("content");

		NewInspirationVo newInspirationVo = new NewInspirationVo();
		newInspirationVo.setNewIdeaid(newIdeaid);
		newInspirationVo.setContent(content);
		newThinkManageService.addNewInspiration(newInspirationVo);

		List<NewInspirationVo> list = new ArrayList<NewInspirationVo>();
		List<NewInspirationVo> inspirationList = null;
		inspirationList = newThinkManageService
				.showNewInspirationbyId(newIdeaid);
		for (NewInspirationVo userCommentVo : inspirationList)
			list.add(userCommentVo);
		return list;
	}

	@RequestMapping(value = "/newThinkManage.action", params = "m=modify_ajax")
	@ResponseBody
	public String userThinkModify_ajax(ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		long newIdeaid = Long.parseLong(request.getParameter("newIdeaid"));
		String content = request.getParameter("content");

		NewAnotationVo newAnotationVo = new NewAnotationVo();
		newAnotationVo.setNewIdeaid(newIdeaid);
		newAnotationVo.setContent(content);
		newAnotationVo.setId(id);
		newThinkManageService.modifyNewAnotation(newAnotationVo);

		return null;
	}

}