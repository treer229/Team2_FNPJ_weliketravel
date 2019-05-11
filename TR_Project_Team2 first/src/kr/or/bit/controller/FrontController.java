package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.LoginOkService;
import kr.or.bit.service.MemberInsert;
import kr.or.bit.service.QnaWriteService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
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
    	
    	
    	if(url_Command.equals("/Loginok.do")) {// 업무처리
    		action = new LoginOkService();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("로그인업무 실패");
				e.printStackTrace();
			}
    		
    	}else if(url_Command.equals("/SighUp.do")) {
    		forward = new ActionForward();
    		forward.setPath("/WEB-INF/Page/sighup.jsp");
    	}else if(url_Command.equals("/SighUpok.do")) {
    		action = new MemberInsert();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("회원가입 업무 실패");
				e.printStackTrace();
			}
    	}
    	
    	if(forward != null){
			if(forward.isRedirect()){
			   response.sendRedirect(forward.getPath());
			}else{
			   RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			   dispatcher.forward(request, response);
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

