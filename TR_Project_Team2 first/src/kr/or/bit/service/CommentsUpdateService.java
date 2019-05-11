package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoticeCommentsDao;
import kr.or.bit.dto.Notice_Comments;

public class CommentsUpdateService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));//글번호
		int notice_comment_num = Integer.parseInt(request.getParameter("notice_comment_num"));//댓글번호
		String notice_content = request.getParameter("notice_comments_conntent");
		String id = request.getParameter("id");
		String sessionid = request.getParameter("sessionid");
		
		
		if(!id.equals(sessionid)||notice_num==0) {//세션에 저장된 id값과 댓글에 저장된 id 값이 다를경우 공지로 이동
			request.setAttribute("notice_num", notice_num);//내가 댓글을 쓴 공지글 번호
			forward.setPath("/noticomlist.Comments");	//댓글을 작성한 공지 글번호로 이동
		} 
		
		request.setAttribute("notice_num", notice_num);
		request.setAttribute("notice_content", notice_content);
		request.setAttribute("notice_comment_num", notice_comment_num);
		
		forward.setRedirect(false);
		forward.setPath("comments_edit");
		return forward;
	}

}
