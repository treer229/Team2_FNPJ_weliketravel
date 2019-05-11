package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ScheduleDAO;

public class ScheduleDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int schedule_num = Integer.parseInt(request.getParameter("schedule_num"));
		
		ScheduleDAO dao = new ScheduleDAO();
		
		dao.getDeleteSchedule(schedule_num);
		forward.setPath("/list.Schedule");
		return forward;
	}

}
