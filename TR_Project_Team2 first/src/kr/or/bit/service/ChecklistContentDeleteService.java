package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ChecklistDAO;
import kr.or.bit.dto.Checklistcontent;

public class ChecklistContentDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int clc_num = Integer.parseInt(request.getParameter("clc_num"));
		
		ChecklistDAO dao = new ChecklistDAO();
		Checklistcontent content = new Checklistcontent();
		
		dao.getDeleteChecklistContent(clc_num);
		forward.setPath("/CheckContent.Checklist");
		return forward;
	}

}
