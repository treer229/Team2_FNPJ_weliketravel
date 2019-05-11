package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;


public class QnaDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		  
		//request.setCharacterEncoding("utf-8");
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		String id = request.getParameter("id");
		String msg = "";
		String url ="";
		
//		if(qna_num == null || qna_num.trim().equals("")){
		if(qna_num == 0) {
			response.sendRedirect("Qnalist.jsp");
		}
		  
		QnaDao dao = new QnaDao();
		int result = dao.deleteOk(qna_num, id);
		
		if(result>0) {
			System.out.println("글 삭제 성공");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println("글 삭제 실패");
			request.setAttribute("result", "fail");
		}
		request.setAttribute("qna_num", qna_num);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WebContent/qna_deleteok.jsp");
  
		return forward;
		
	}
}
