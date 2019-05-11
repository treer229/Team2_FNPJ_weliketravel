package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;

public class MemberDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		

		ActionForward forward = null;
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			String id = request.getParameter("id");
			MemberDao dao = new MemberDao();
			int result = dao.MemberDelete(id);
			
			if(result>0) {
				out.print("<script>alert('삭제 성공');</script>");
			}
			else {
				out.print("<script>alert('삭제 실패');</script>");
			}
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		forward = new ActionForward();
		forward.setPath("/MemberList.do");
		return forward;
	}
}
