package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class MemberEdit implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        ActionForward forward= null;
        Member MemberList =null;
        String id=request.getParameter("id");
   

		try {
			MemberDao dao = new MemberDao();
			MemberList = dao.MemberEdit(id);
			
			

	  		System.out.println(forward);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("id",MemberList);
		forward = new ActionForward();
		forward.setPath("/WEB-INF/Ajax/Update.jsp");
		
		
		return forward;
	}

}