package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.TravelReviewDao;

/*
작업일자 : 2019-05-09
작업자 :   이힘찬
작업내용 : TravelReviewReplyService 작성
*/

public class TravelReviewReplyService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		//서비스 객체 호출하고
		//insert 하고
		TravelReviewDao dao = new TravelReviewDao();
		
		int comments_num = Integer.parseInt(request.getParameter("comments_num"));
		String id = request.getParameter("id");
		int tr_num = Integer.parseInt(request.getParameter("tr_num"));
		String comments_content = request.getParameter("comments_content");
		String comments_date = request.getParameter("comments_date");
		
		id = "empty";

		//서비스 객체 호출하고
		//insert 하고
		int result = dao.commentwrite(tr_num, comments_num, id, comments_content, comments_date);
		
		if(result>0) {
			request.setAttribute("result", "success");
		}
		else {
			request.setAttribute("result", "fail");
		}
		
		request.setAttribute("tr_num",tr_num);
		
		ActionForward forward = new ActionForward();
	    
	    forward.setRedirect(false);
		forward.setPath("/board/board_replyok.jsp");
		
		return forward;
	}

}
