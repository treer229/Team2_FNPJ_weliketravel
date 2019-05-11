package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ChecklistDAO;
import kr.or.bit.dto.Checklist;

public class ChecklistUpdateService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int cl_num = Integer.parseInt(request.getParameter("cl_num"));
		
		ChecklistDAO dao = new ChecklistDAO();
		Checklist list = dao.getCheckList(cl_num);
		
		request.setAttribute("list", list);
		forward.setPath("/WEB-INF/Page/edittest.jsp");
		return forward;
	}

}
