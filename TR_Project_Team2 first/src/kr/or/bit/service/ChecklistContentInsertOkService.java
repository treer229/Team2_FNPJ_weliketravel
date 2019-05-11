package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.Content;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ChecklistDAO;
import kr.or.bit.dto.Checklistcontent;

public class ChecklistContentInsertOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int clc_num = Integer.parseInt(request.getParameter("num"));
		System.out.println("num받냐?>" + clc_num);
		String contents = request.getParameter("content");
		
		
		ChecklistDAO dao = new ChecklistDAO();
		Checklistcontent content = new Checklistcontent();
		
		content.setCl_num(clc_num);
		content.setContent(contents);
		
		dao.getInsertChecklistContent(content);
		
		request.setAttribute("num", clc_num);
		System.out.println("컨텐츠 글번호 : " + clc_num);
		forward.setPath("CheckContent.Checklist"); // web-inf 가면 앞에 /붙일수도 있음.
		return forward;
	}

}
