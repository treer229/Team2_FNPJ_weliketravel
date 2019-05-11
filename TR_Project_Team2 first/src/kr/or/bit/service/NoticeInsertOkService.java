package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoticeDao;
import kr.or.bit.dto.Notice;

public class NoticeInsertOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String id = request.getParameter("id");
		String content = request.getParameter("Notice_content");
		String title = request.getParameter("notice_title");
		
		NoticeDao notidao = new NoticeDao();
		Notice notice = new Notice();
		notice.setId(id);
		notice.setnotice_content(content);
		notice.setnotice_title(title);
		
		notidao.noticeWrite(notice);
		
		
		return forward;
	}

}
