package kr.or.bit.service;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoticeCommentsDao;
import kr.or.bit.dto.Notice_Comments;


public class CommentsListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		
		System.out.println(notice_num);
		
		NoticeCommentsDao notidao = new NoticeCommentsDao();

		List<Notice_Comments> notilist = notidao.noticeCommentList(notice_num);
		
		System.out.println("노티리스트"+notilist);
		request.setAttribute("notilist", notilist);
		ActionForward forward = new ActionForward();
		
		forward.setPath("/WEB-INF/Page/test.jsp");
		System.out.println("보여주기 끝");
		return forward;
	}
	
	
}
