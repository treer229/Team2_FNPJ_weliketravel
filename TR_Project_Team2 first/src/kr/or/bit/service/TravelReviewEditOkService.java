package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.TravelReviewDao;

/*
작업일자 : 2019-05-09
작업자 :   이힘찬
작업내용 : TravelReviewEditOkService 작성
*/

public class TravelReviewEditOkService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("utf-8");
		
		String idx = request.getParameter("idx");
		String msg = "";
		String url ="";
		PrintWriter out = response.getWriter();
		
		if(idx == null || idx.trim().equals("")){
			out.print("<script>");
			out.print("alert('글번호 오류');");
			out.print("location.href='board_list.jsp'");	   
			out.print("</script>");
		}
		//boardservice service = boardservice.getInstance();
		//int result = service.board_edit(request);
		
		TravelReviewDao dao = new TravelReviewDao();
		int result = dao.boardedit(request);
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("result", result);
	    request.setAttribute("idx", idx);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/board_editok.jsp");
		
		return forward;
	}

}
