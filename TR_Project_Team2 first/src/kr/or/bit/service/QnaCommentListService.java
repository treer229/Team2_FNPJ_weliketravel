package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.simple.JSONArray;
import net.sf.json.JSONArray;
import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.QnaDao;
import kr.or.bit.dto.Qna_Comments;

public class QnaCommentListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("commentlist들어옴");
		int comments_num = Integer.parseInt(request.getParameter("comments_num"));
		String ps = request.getParameter("ps");
		String cp = request.getParameter("cp");
		List<Qna_Comments> replylist = null;
		
		try {
			QnaDao dao = new QnaDao();
			replylist = dao.commentList(comments_num);
			System.out.println(1);
			JSONArray jsonarray = JSONArray.fromObject(replylist);
			System.out.println(2);
			request.setAttribute("jsonarray", jsonarray);
			System.out.println(3);
			System.out.println("오니? " +jsonarray);
		}catch(Exception e) {
			System.out.println("에러뜬다");
		}finally {
			
		}
		ActionForward forward = new ActionForward();
		forward.setPath("/board/replyjson.jsp");
		
		return forward;
	}

}


