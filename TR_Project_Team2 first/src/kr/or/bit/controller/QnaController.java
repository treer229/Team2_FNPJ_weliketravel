package kr.or.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.QnaWriteService;


@WebServlet("*.Qna")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QnaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ActionForward forward = new ActionForward();
    	Action action = null;
    	
    	//요청받기 시작
    	String requestURI = request.getRequestURI();
    	String ContextPath = request.getContextPath();
    	String url_Command = requestURI.substring(ContextPath.length());

    	System.out.println("requestURI"+requestURI+"컨트롤러 check");
    	System.out.println("ContextPath"+ContextPath+"컨트롤러 check");
    	System.out.println("url_Command"+url_Command+"컨트롤러 check");
    	
    	
    	if(url_Command.equals("/QnaWrite.Qna")) {// 업무처리
    	   forward.setRedirect(false);
    	   forward.setPath("/board/board_write.jsp");
    	   System.out.println("if확인");
			
			 

    	}  else if(url_Command.equals("/MemoList.do")) {
    		forward = new ActionForward();
    //		forward.setPath(/*여기에 주소를 넣어주세요*/);
    		action=new QnaWriteService();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
