<%@page import="kr.or.bit.dao.QnaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String msg = "";
	String url ="";
	
	
	String result = (String)request.getAttribute("result");
	String qna_num = (String)request.getAttribute("qna_num");

	if(result.equals("success")) {
		msg = "delete success";
		url ="boardlist.bbs";
	}
	else{
		msg = "delete fail";
		url ="boardRead.bbs?qna_num="+qna_num;
	}
	
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp" />    