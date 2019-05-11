package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ScheduleDAO;
import kr.or.bit.dto.Schedule;

public class ScheduleInsertOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
	String id =	request.getParameter("id");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String start =	request.getParameter("start");
	String end =	request.getParameter("end");
	String color =	request.getParameter("color");
	int del = Integer.parseInt(request.getParameter("del"));
	int com = Integer.parseInt(request.getParameter("com"));
		
		ScheduleDAO dao = new ScheduleDAO();
		Schedule sc = new Schedule();
		
		sc.setId(id);
		sc.setSchedule_title(title);
		sc.setContent(content);
		sc.setSchedule_start(start);
		sc.setSchedule_end(end);
		sc.setColor(color);
		sc.setDeleteok(del);
		sc.setCompleteok(com);
		
		dao.getInsertSchedule(sc);
		
		request.setAttribute("id", id);
		
		forward.setRedirect(true);
		forward.setPath("list.Schedule");
		
		return forward;
	}

}
