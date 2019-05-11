package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;
import kr.or.bit.dto.Qna;


public class QnaWriteService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QnaDao dao = new QnaDao();
		Qna qna = new Qna();
		
		qna.setQna_num(Integer.parseInt(request.getParameter("qna_num")));
		qna.setId(request.getParameter("id"));
		qna.setQna_title(request.getParameter("qna_title"));
		qna.setContent(request.getParameter("content"));
		qna.setViews(Integer.parseInt(request.getParameter("views")));
		qna.setCreated_date(request.getParameter("created_date"));
		qna.setComment_count(Integer.parseInt(request.getParameter("comment_count")));
		
		
		int result = dao.writeok(qna);
		
		if(result>0) {
			System.out.println("글 입력 성공");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println("글 입력 실패");
			request.setAttribute("result", "fail");
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/board/board_writeok.jsp");
  
		return forward;
	}

}

