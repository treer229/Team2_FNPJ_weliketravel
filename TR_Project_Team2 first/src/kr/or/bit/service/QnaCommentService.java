package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;


public class QnaCommentService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		//서비스 객체 호출하고
		//insert 하고
		QnaDao dao = new QnaDao();
		
		int comments_num =	Integer.parseInt(request.getParameter("comments_num"));
		String id = request.getParameter("id");
		System.out.println("id :" + id);
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		
		String comments_content = request.getParameter("comments_content");
		System.out.println("comments_content : " + comments_content);
		
		String comments_date = request.getParameter("comments_date");
		id = "empty";

		//서비스 객체 호출하고
		//insert 하고
		int result = dao.commentWrite(qna_num, comments_num, id, comments_content, comments_date);
		
		if(result>0) {
			request.setAttribute("result", "success");
		}
		else {
			request.setAttribute("result", "fail");
		}
		
		request.setAttribute("comments_num", comments_num);
		
		ActionForward forward = new ActionForward();
	    
	    forward.setRedirect(false);
		forward.setPath("/board/board_replyok.jsp");
		
		return forward;
	}

}
