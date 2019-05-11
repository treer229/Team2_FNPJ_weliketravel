package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class ChecklistContentInsetService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int cl_num = Integer.parseInt(request.getParameter("cl_num"));
		int clc_num = Integer.parseInt(request.getParameter("num"));
		request.setAttribute("cl_num", cl_num);
		request.setAttribute("num", clc_num);
		
		System.out.println("num값 :" + clc_num );
		forward.setPath("/WEB-INF/Page/contentinsert.jsp");
		return forward;
	}

}
