package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class MemberInsert implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		MemberDao dao = new MemberDao();
		Member member = new Member();
		
		boolean result = false;
		
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setGender(Integer.parseInt(request.getParameter("gender")));
		member.setEmail(request.getParameter("email"));
		member.setTravel(request.getParameter("travel"));
		
		result = dao.MemberInsert(member);
		if(result==false) {
			System.out.println("회원가입 실패!");
			return null;
		}
		
		//회원가입 성공
		forward.setRedirect(true);
		forward.setPath("Index.jsp");
		return forward;
	}

}
