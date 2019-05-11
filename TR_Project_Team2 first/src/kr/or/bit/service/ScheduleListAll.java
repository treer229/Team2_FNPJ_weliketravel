package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ScheduleDAO;
import kr.or.bit.dto.Member;
import kr.or.bit.dto.Schedule;

public class ScheduleListAll implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		ScheduleDAO dao = new ScheduleDAO();
		
		Member memeber = new Member();
		
		if(request.getParameter("id") == null) {
		List<Schedule> list = dao.getScheduleListAll("admin");
		request.setAttribute("list", list);
		}else {
		String id = request.getParameter("id");
		List<Schedule> list = dao.getScheduleListAll(id);
		request.setAttribute("list", list);
		}
		

		forward.setPath("/WEB-INF/Page/Schedulelisttest.jsp");
		return forward;
	}

}
