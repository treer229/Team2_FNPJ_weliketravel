package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.TravelReviewDao;
import kr.or.bit.dto.TravelReview_Comments;
import net.sf.json.JSONArray;

/*
작업일자 : 2019-05-09
작업자 :   이힘찬
작업내용 : TravelReviewReplyListService 작성
*/

public class TravelReviewReplyListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("replylist들어옴");
		int tr_num = Integer.parseInt(request.getParameter("tr_num"));
		String ps = request.getParameter("ps");
		String cp = request.getParameter("cp");
		List<TravelReview_Comments> replylist = null;
		
		try {
			TravelReviewDao dao = new TravelReviewDao();
			replylist = dao.commentlist(tr_num);
			System.out.println(1);
			JSONArray jsonarray = JSONArray.fromObject(replylist);
			System.out.println(2);
			request.setAttribute("jsonarray", jsonarray);
			System.out.println(3);
			System.out.println("오니? " +jsonarray);
		}catch(Exception e) {
			System.out.println("에러뜬다");
		}finally {
			
		}
		ActionForward forward = new ActionForward();
		forward.setPath("/board/replyjson.jsp");
		
		return forward;
	}

}
