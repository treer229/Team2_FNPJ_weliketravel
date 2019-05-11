package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoticeCommentsDao;

public class CommentsDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		String id = request.getParameter("id");
		String sessionid = request.getParameter("sessionid");
		
		if(id.equals(sessionid)) {
			NoticeCommentsDao noticomdao = new NoticeCommentsDao();
			noticomdao.deleteComment(id, comment_num);
		} else {
			System.out.println("실패");
		}
		
		request.setAttribute("notice_num", notice_num);
		forward.setPath("/noticomlist.Comments");
		
		return forward;
	}
	
}
