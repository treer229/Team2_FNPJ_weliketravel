package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.TravelReviewDao;
import kr.or.bit.dto.TravelReview;

/*
작업일자 : 2019-05-09
작업자 :   이힘찬
작업내용 : TravelReviewListService 작성
*/

public class TravelReviewListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		TravelReviewDao dao = new TravelReviewDao();
		int totalboardCount = dao.totalboardCount();
		
		String psStr = request.getParameter("ps");    //pagesize
        String cpStr = request.getParameter("cp");    //currentpage
        
        if(psStr == null || psStr.trim().equals("")){
            //default 값
            psStr = "5"; // default 5건씩 
        }
        
        if(cpStr == null || cpStr.trim().equals("")){
            cpStr= "1";        //default 1 page
        }
      
        int pagesize = Integer.parseInt(psStr);  //5
        int cpage = Integer.parseInt(cpStr);     //1
        int pagecount = 0;                       
        
        if(totalboardCount % pagesize==0){        //전체 건수 , pagesize > 
            pagecount = totalboardCount/pagesize;
        }else{
            pagecount = (totalboardCount/pagesize) + 1;
        }
        //페이지 갯수 : 102 건 , pagesize :5   pagecount: 21
        
        
        List<TravelReview> list= dao.list(cpage, pagesize);
        
        ActionForward forward = new ActionForward();
        request.setAttribute("cpage", cpage);
        request.setAttribute("pagesize", pagesize);
        request.setAttribute("pagecount", pagecount);
        request.setAttribute("list", list);
        request.setAttribute("totalboardCount", totalboardCount);
        
        forward.setRedirect(false);
		forward.setPath("/travelreview/travelreviewList.jsp");
		
		return forward;
	}

}
