package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ChecklistDAO;
import kr.or.bit.dto.Checklist;
import kr.or.bit.dto.Checklistcontent;

public class ChecklistContentViewService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		
		ActionForward forward = new ActionForward();
		ChecklistDAO dao = new ChecklistDAO();
		Checklist check = new Checklist();
		List<Checklistcontent> clc = dao.getChecklistContent(num);
		
		check = dao.getCheckList(num);
		
		request.setAttribute("content", clc);
		request.setAttribute("title", check);
		request.setAttribute("num", num);
		forward.setPath("/WEB-INF/Page/content.jsp");
		
		return forward;
	}

}
