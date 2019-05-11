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
import kr.or.bit.service.ScheduleInsertOkService;
import kr.or.bit.service.ScheduleDeleteService;
import kr.or.bit.service.ScheduleEditService;
import kr.or.bit.service.ScheduleEditOkService;
import kr.or.bit.service.ScheduleListService;


@WebServlet("*.Schedule")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ActionForward forward = null;
    	Action action = null;
    	
    	//요청받기 시작
    	String requestURI = request.getRequestURI();
    	String ContextPath = request.getContextPath();
    	String url_Command = requestURI.substring(ContextPath.length());

    	System.out.println("requestURI"+requestURI+"컨트롤러 check");
    	System.out.println("ContextPath"+ContextPath+"컨트롤러 check");
    	System.out.println("url_Command"+url_Command+"컨트롤러 check");
    	
    	
    	if(url_Command.equals("/list.Schedule")) {// 업무처리
	      	 action = new ScheduleListService();
	      	 try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("스케줄리스트 업무 에러");
				e.printStackTrace();
			}
		}else if(url_Command.equals("/insert.Schedule")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/Page/insertschedule.jsp");
		}else if(url_Command.equals("/insertOk.Schedule")) {
			action = new ScheduleInsertOkService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("스케줄추가 업무 에러");
				e.printStackTrace();
			}
		}else if(url_Command.equals("/edit.Schedule")) {
			action = new ScheduleEditService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("스케줄수정 업무 에러");
				e.printStackTrace();
			}
		}else if(url_Command.equals("/editok.Schedule")) {
			action = new ScheduleEditOkService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("스케줄 업데이트 업무 에러");
				e.printStackTrace();
			}
		}else if(url_Command.equals("/del.Schedule")) {
			action = new ScheduleDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("스케줄삭제 업무 에러");
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
