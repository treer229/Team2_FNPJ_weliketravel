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
작업내용 : TravelReviewContentService 작성
*/

public class TravelReviewContentService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("오늘은 금요일 이다씨발");
		int tr_num = Integer.parseInt(request.getParameter("tr_num")); //글번호
		
		System.out.println("오늘은 금요일 오잉");
		//글번호를 가지고 오지 않았을 경우 예외처리
		//if(idx==null || idx.trim().equals("")){
		if(tr_num == 0) {
			
			response.sendRedirect("travelreviewlist.TravelReview");
		}
		
		
		//idx = idx.trim();
	
		//list 다시 넘어갈때 현재 페이지 * 페이지 사이즈////////////
	    String cpage =	request.getParameter("cp"); //현재 페이지 번호
	    String pagesize =	request.getParameter("ps"); //pagesize 정보
	
	    if(cpage==null || cpage.trim().equals("")){
			cpage="1";
		}
		if(pagesize==null || pagesize.trim().equals("")){
			pagesize="5";
		}
		
		TravelReviewDao dao = new TravelReviewDao();
		
		//조회수 증가
		boolean res = dao.getReadnum(tr_num);
		if(res) System.out.println("조회수 증가");
			
		//데이터 조회 출력(글번호가 없는 게시글에 조회시 ...)
		TravelReview boarddto = dao.getContent(tr_num);//content(Integer.parseInt(idx));
		if(boarddto == null){
			response.sendRedirect("TravelReviewList.TravelReview");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("boarddto", boarddto);
	    request.setAttribute("tr_num", tr_num);
	    request.setAttribute("cpage", cpage);
	    request.setAttribute("pagesize", pagesize);
	    request.setAttribute("dao", dao);
	    
	    forward.setRedirect(false);
		forward.setPath("/travelreview/travelreviewContent.jsp");
		
		return forward;
	}
}
