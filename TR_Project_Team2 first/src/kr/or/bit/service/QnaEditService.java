package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;
import kr.or.bit.dto.Qna;


public class QnaEditService implements Action{


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//수정하기
		
		//request.setCharacterEncoding("UTF-8");
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));//글번호
//		if (idx == null || idx.trim().equals("")) {
		if(qna_num ==0) {
			response.sendRedirect("board_list.jsp");
		}
		
		QnaDao dao = new QnaDao();
		Qna qna = dao.getEditContent(qna_num);
		//PrintWriter out = response.getWriter();
		
		
		if (qna == null) {
			System.out.println("데이터 오류");
			response.sendRedirect("board_list.jsp");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("qna", qna);
	    request.setAttribute("qna_num", qna_num);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/board_edit.jsp");
		
		return forward;
	}

}
