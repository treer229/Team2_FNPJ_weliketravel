<%@page import="java.util.List"%>
<%@page import="kr.or.bit.dto.TravelReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <link rel="Stylesheet" href="<%=request.getContextPath()%>/style/default.css" /> --%>
</head>
<body>
	<%-- <c:import url="/include/header.jsp" /> --%>
	게시판 목록
	<br>
	<%  
        int cpage = (Integer)request.getAttribute("cpage");
        int pagesize = (Integer)request.getAttribute("pagesize");
        int pagecount = (Integer)request.getAttribute("pagecount");
        int totalboardCount = (Integer)request.getAttribute("totalboardCount");
        List<TravelReview> list = (List)request.getAttribute("list");
    %>
	<c:set var="pagesize" value="<%=pagesize%>" />
	<c:set var="cpage" value="<%=cpage%>" />
	<c:set var="pagecount" value="<%=pagecount%>" />
	<c:set var="list" value="<%=list%>"/>
	<c:set var="totalboardCount" value="<%=totalboardCount%>"/>
	<div id="pagecontainer">
		<div style="padding-top: 30px; text-align: cetner">
			<table width="80%" border="1" cellspacing="0" align="center">
				<tr>
					<td colspan="5">
						<form name="list">
						PageSize설정: 
							<select name="ps" onchange="submit()">
								<%
				   					/* 
				   						for(int i =5 ; i <=20 ;i+=5){
										if(pagesize == i){
											out.println("<option value='" + i + "' selected='selected'>" + i +"개</option>");
										}else{
											out.println("<option value='" + i + "'>" + i +"개</option>");
										}
										} 
									*/
		   						%>
		   						<c:forEach var="i" begin="5" end="20" step="5">
		   							<c:choose>
									<c:when test="${pagesize == i}">
	                            		 <option value='${i}' selected>${i}건</option>
	                        		</c:when>
									<c:otherwise>
	                                  	  <option value='${i}'>${i}건</option>
	                               </c:otherwise>
								</c:choose>
		   						</c:forEach>
		   					</select>
						</form>
					</td>
				</tr>
				<tr>
					<th width="10%">순번</th>
					<th width="40%">제목</th>
					<th width="20%">글쓴이</th>
					<th width="20%">날짜</th>
					<th width="10%">조회수</th>
				</tr>
				<!-- 데이터가 한건도 없는 경우  -->
				<%
		     	if(list == null || list.size() == 0){
		     		out.print("<tr><td>데이터가 없습니다</td></tr></table>");
		     		return;
		     	} 
		       %>
	       
		       
				<c:forEach var="board" items="<%=list%>">
					<c:set var="tr_num" value="${board.tr_num }" />
					<c:set var="tr_title" value="${board.tr_title}" />
					<c:set var="id" value="${board.id}" />
					<tr onmouseover="this.style.backgroundColor='gray'"
						onmouseout="this.style.backgroundColor='white'">
						<td align="center">${board.tr_num}</td>
						<td align="left">
							  <c:forEach var="i" begin="1" end="${board.depth}" step="1">
                        		&nbsp;&nbsp;&nbsp;
                    		 </c:forEach>  
                    		<c:if test="${board.depth>0}">
								<img src='img/board/re.gif' />
							</c:if>  
							<a href='TravelReviewRead.TravelReview?idx=${tr_num}&cp=${cpage}&ps=${pagesize}'>
								<c:choose>
									<c:when test="${tr_title != null && fn:length(tr_title)> 10}">
	                            		${fn:substring(tr_title, 0, 10)}....
	                        		</c:when>
									<c:otherwise>
	                                  	${tr_title}
	                               </c:otherwise>
								</c:choose>
							</a>
						</td>
						<td align="center">
							<c:choose>
								<c:when test="${id != null && fn:length(id) > 4}">
                                	${fn:substring(id, 0, 4)}...
                            	</c:when>
								<c:otherwise>
                             	 ${id}
                           		</c:otherwise>
							</c:choose>
						</td>
						<td align="center">${board.created_date}</td>
						<td align="center">${board.views}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="center">
						<hr width="100%" color="red">
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<!--이전 링크 --> 
						<c:if test="${cpage>1}">
							<a href="boardlist.bbs?cp=${cpage-1}&ps=${pagesize}">이전</a>
							<!--페이지 리스트 구현  -->
						</c:if> 
						<c:forEach var="i" begin="1" end="${pagecount}" step="1">
							<c:choose>
								<c:when test="${cpage==i}">
									<font color='red'>[${i}]</font>
								</c:when>
								<c:otherwise>
									<a href="boardlist.bbs?cp=${i}&ps=${pagesize}">[${i}]</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> 
						<!--다음 링크 --> 
						<c:if test="${cpage<pagecount}">
							<a href="../travelreviewlist.TravelReview?cp=${cpage+1}&ps=${pagesize}">다음</a>
						</c:if>
					</td>
					<td colspan="2" align="center">총 게시물 수 : <%=totalboardCount %>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>