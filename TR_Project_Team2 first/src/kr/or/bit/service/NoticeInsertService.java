package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class NoticeInsertService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String id = request.getParameter("id");
		String sessionid = request.getParameter("sessionid");
		
		if(id.equals(sessionid)) {
			response.sendRedirect("");//공지 사항으로 이동
		}
		
		request.setAttribute("id", id);
		
		forward.setPath("");//insertok로 보내자
		return forward;
	}

}
