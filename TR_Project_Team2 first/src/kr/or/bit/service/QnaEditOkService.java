package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;

public class QnaEditOkService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("utf-8");
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		String msg = "";
		String url ="";
		PrintWriter out = response.getWriter();
		
//		if(idx == null || idx.trim().equals("")){
		if(qna_num==0) {
			out.print("<script>");
			out.print("alert('글번호 오류');");
			out.print("location.href='board_list.jsp'");	   
			out.print("</script>");
		}
		//boardservice service = boardservice.getInstance();
		//int result = service.board_edit(request);
		
		QnaDao dao = new QnaDao();
		int result = dao.boardEdit(request);
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("result", result);
	    request.setAttribute("qna_num", qna_num);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/board_editok.jsp");
		
		return forward;
	}
}
