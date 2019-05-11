package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;
import kr.or.bit.dto.Qna;


public class QnaContentService implements Action{

		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

			int qna_num = Integer.parseInt(request.getParameter("qna_num")); //글번호
		
			//글번호를 가지고 오지 않았을 경우 예외처리
//			if(qna_num==null || qna_num.trim().equals("")){
			if(qna_num == 0) {
				response.sendRedirect("Qnalist.jsp");
			}
			
//			qna_num = qna_num.trim();
		
			//list 다시 넘어갈때 현재 페이지 * 페이지 사이즈////////////
		    String cpage =	request.getParameter("cp"); //현재 페이지 번호
		    String pagesize =	request.getParameter("ps"); //pagesize 정보
		
		    if(cpage==null || cpage.trim().equals("")){
				cpage="1";
			}
			if(pagesize==null || pagesize.trim().equals("")){
				pagesize="5";
			}
			/////////////////////////////////////////////////////
			QnaDao dao = new QnaDao();
			
			//조회수 증가
			boolean res = dao.getReadnum(qna_num);
			if(res) System.out.println("조회수 증가");
				
			//데이터 조회 출력(글번호가 없는 게시글에 조회시 ...)
			Qna qna = dao.getContent(qna_num);//content(Integer.parseInt(idx));
			if(qna == null){
				response.sendRedirect("boardlist.do");
			}
			
			ActionForward forward = new ActionForward();
		    request.setAttribute("qna", qna);
		    request.setAttribute("qna_num", qna_num);
		    request.setAttribute("cpage", cpage);
		    request.setAttribute("pagesize", pagesize);
		    request.setAttribute("dao", dao);
		    
		    forward.setRedirect(false);
			forward.setPath("/WebContent/Index.jsp");
			
			return forward;
		}
}
