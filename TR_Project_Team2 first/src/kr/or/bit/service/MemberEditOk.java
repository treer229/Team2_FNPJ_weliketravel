package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;


public class MemberEditOk implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		String id = request.getParameter("id");
		System.out.println(id +" 정보수정");
		int row = 0;
		PrintWriter out = null;
		
		
		try {
		MemberDao dao = new MemberDao();
		Member member = new Member();
		out = response.getWriter();	
		
		member.setId(id);
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setGender(Integer.parseInt(request.getParameter("gender")));
		member.setEmail(request.getParameter("email"));
		member.setTravel(request.getParameter("travel"));
		member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		
		row=dao.MemberEdit(member);
		
		if(row>0) {
			out.print("<script>alert('수정 성공');</script>");
		}else {
			out.print("<script>alert('수정 실패');</script>");
		}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		forward = new ActionForward();
		forward.setPath("/MemberList.do");
		return forward;
	}

}
