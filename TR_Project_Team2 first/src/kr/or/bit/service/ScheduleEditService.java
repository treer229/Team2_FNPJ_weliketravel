package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ScheduleDAO;
import kr.or.bit.dto.Schedule;

public class ScheduleEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int schedule_num = Integer.parseInt(request.getParameter("schedule_num"));
		
		ScheduleDAO dao = new ScheduleDAO();
		Schedule schedule = dao.getScheduleList(schedule_num);
		
		request.setAttribute("schedule", schedule);
		forward.setPath("/WEB-INF/Page/scheduleedit.jsp");
		return forward;
	}

}
