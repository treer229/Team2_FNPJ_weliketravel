package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class LoginOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		
		MemberDao dao = new MemberDao();
		
		Member member = dao.MemberSearch(id);
		System.out.println("id : " + id );
		System.out.println("pwd : " + pwd);
		ActionForward forward = new ActionForward();
		if(member.getPassword().equals(pwd)) {
			forward.setPath("/WEB-INF/Page/index.html");
		}else {
			forward.setRedirect(true);
			forward.setPath("Index.jsp");
		}
		
		
		
		
		return forward;
	}

}
