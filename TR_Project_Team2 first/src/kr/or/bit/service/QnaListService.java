package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;
import kr.or.bit.dto.Qna;

public class QnaListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QnaDao dao = new QnaDao();
		int totalboardCount = dao.totalboardCount();
		
		String psStr = request.getParameter("ps");
		String cpStr = request.getParameter("cp");
		
		if(psStr == null || psStr.trim().equals("")) {
			psStr = "5";
		}
		if(cpStr == null || cpStr.trim().equals("")) {
			cpStr="1";
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
        
        List<Qna> list = dao.list(cpage, pagesize);
        
        ActionForward forward = new ActionForward();
        request.setAttribute("cpage", cpage);
        request.setAttribute("pagesize", pagesize);
        request.setAttribute("pagecount", pagecount);
        request.setAttribute("list", list);
        request.setAttribute("totalboardCount", totalboardCount);
        
        forward.setRedirect(false);
		forward.setPath("/board/board_list.jsp");//수정해야댐
		
		return forward;
	}
}
