package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoticeCommentsDao;
import kr.or.bit.dto.Notice_Comments;

public class CommentsInsertService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("comments 서비스 시작");
		String id = request.getParameter("id");//글쓴이 아이디
		String content = request.getParameter("content");//댓글 내용
		String date = request.getParameter("date");//댓글을 쓴 날자
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));//글번호 받아와야 댓글을 찾을 수 있습니다.
		
		System.out.println(id);
		System.out.println(content);
		System.out.println(date);
		System.out.println(notice_num);
		
		Notice_Comments noticomments = new Notice_Comments();
		
		noticomments.setNotice_num(notice_num);
		noticomments.setId(id);
		noticomments.setComments_content(content);
		
		System.out.println(noticomments.toString());
		
		NoticeCommentsDao noticommentsdao = new NoticeCommentsDao();
		noticommentsdao.insertComment(noticomments);
		
		
		ActionForward forward = new ActionForward();
		request.setAttribute("notice_num", notice_num);
		forward.setPath("/noticomlist.Comments");
		System.out.println("서비스 끝");
		return forward;
	}
}
