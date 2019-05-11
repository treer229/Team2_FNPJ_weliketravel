package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;

public class QnaCommentDeleteService implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num")); //덧글의 원본 게시글 번호
		int comments_num =	Integer.parseInt(request.getParameter("comments_num")); //덧글의 순번(고유값)
		String id =	request.getParameter("id"); //덧글의 암호
		   
		
		   
		QnaDao dao = new QnaDao();
		int result = dao.commentDelete(comments_num, id);
		
		if(result>0) {
			request.setAttribute("result", "success");
		}
		else {
			request.setAttribute("result", "fail");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("qna_num", qna_num);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/boardreply_deleteOk.jsp");
		
		return forward;
	}

}
