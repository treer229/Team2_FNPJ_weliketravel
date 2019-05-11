package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ChecklistDAO;
import kr.or.bit.dto.Checklist;

public class ChecklistUpdateOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int cl_num = Integer.parseInt(request.getParameter("num"));
		String cl_title = request.getParameter("title");
		String color = request.getParameter("color");
		String id = request.getParameter("id");
		
		ActionForward forward = new ActionForward();
		
		ChecklistDAO dao = new ChecklistDAO();
		Checklist checklist = new Checklist();
		
		checklist.setCl_num(cl_num);
		checklist.setCl_title(cl_title);
		checklist.setColor(color);
		checklist.setId(id);
		
		dao.getUpdateChecklist(checklist);
		
		forward.setPath("/read.Checklist");
		
		return forward;
	}

}
