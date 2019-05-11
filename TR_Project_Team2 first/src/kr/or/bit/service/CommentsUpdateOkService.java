package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoticeCommentsDao;
import kr.or.bit.dto.Notice_Comments;

public class CommentsUpdateOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));//글번호
		int notice_comment_num = Integer.parseInt(request.getParameter("notice_comment_num"));//댓글번호
		String notice_content = request.getParameter("notice_comments_conntent");
		
		NoticeCommentsDao noticomdao = new NoticeCommentsDao();	
		noticomdao.updateComment(notice_comment_num, notice_content);
		
		request.setAttribute("notice_num", notice_num);//내가 댓글을 쓴 공지글 번호
		forward.setPath("/noticomlist.Comments");	//댓글을 작성한 공지 글번호로 이동
		return forward;
	}
	
}
