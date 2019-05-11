package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.TravelReviewDao;
import kr.or.bit.dto.TravelReview;

/*
작업일자 : 2019-05-09
작업자 :   이힘찬
작업내용 : TravelReviewEditService 작성
*/

public class TravelReviewEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//수정하기
		
		//request.setCharacterEncoding("UTF-8");
		
		int tr_num = Integer.parseInt(request.getParameter("tr_num"));//글번호
		
		//if(tr_num == null || tr_num.trim().equals("")){
		if(tr_num==0) {
			response.sendRedirect("board_list.jsp");
		}
		
		TravelReviewDao dao = new TravelReviewDao();
		TravelReview boarddata = dao.getEditContent(tr_num);
		//PrintWriter out = response.getWriter();
		
		
		if (boarddata == null) {
			System.out.println("데이터 오류");
			response.sendRedirect("board_list.jsp");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("boarddata", boarddata);
	    request.setAttribute("tr_num",tr_num);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/board_edit.jsp");
		
		return forward;
	}

}
