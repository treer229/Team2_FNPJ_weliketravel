package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;


public class MemberAllList implements Action{

	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
	ActionForward forward = new ActionForward();
	try {
		MemberDao dao = new MemberDao();
		List<Member> MemberList = dao.MemberAllList();
		
		request.setAttribute("Member", MemberList);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	forward.setPath("/WEB-INF/MemberList.jsp");
	System.out.println(forward);
	return forward;
	}
}
