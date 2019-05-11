<%@page import="kr.or.bit.dto.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8");
	int qna_num = (int)request.getAttribute("qna_num");
	Qna qna = (Qna)request.getAttribute("qna");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="Stylesheet"
	href="<%=request.getContextPath()%>/style/default.css" />
	<script type="text/javascript">
	function editCheck() {

		if (!edit.writer.value) {

			alert("이름을 입력하세요");
			edit.writer.focus();
			return false;
		}
		if (!edit.pwd.value) {
			alert("비밀번호를 입력해야 합니다.");
			edit.pwd.focus();
			return false;
		}

		if (!edit.email.value) {
			alert("이메일을 입력해야합니다.");
			edit.email.focus();
			return false;
		}

		if (!edit.subject.value) {
			alert("제목을 입력하세요");
			edit.subject.focus();
			return false;
		}

		if (!edit.content.value) {
			alert("글 내용을 입력하세요");
			edit.content.focus();
			return false;
		}

		document.edit.submit();

	}
</script>
</head>
<body>
	<%
		pageContext.include("/include/header.jsp");
	%>
	<div id="pageContainer">
		<div style="padding-top: 25px; text-align: center">
			<!-- form 시작 -->
			<form name="edit" action="boardEdit.bbs" method="POST">
				<center>
					<table width="90%" border="1">
						<tr>
							<td width="20%" align="center"><b> 글번호 </b></td>
							<td width="30%">
									<%=qna_num%> 
									<input type="hidden" name="qna_num" value="<%=qna_num%>"></td>
							<td width="20%" align="center"><b>작성일</b></td>
							<td><%=qna.getCreated_date()%></td>
						</tr>
						<tr>
							<td width="20%" align="center"><b>글쓴이</b></td>
							<td width="30%">
								<input type="text" name="writer" value="<%=qna.getId()%>">
							</td>
							<%-- 
							<td width="20%" align="center"><b>홈페이지</b></td>
							<td>
								<input type="text" name="homepage" value="<%=qna.getHomepage()%>">
							</td>
							 --%>
						</tr>
						<tr>
							<td width="20%" align="center"><b>비밀번호</b></td>
							<td>
								<input type="text" name="pwd">
							</td>
							<td width="20%" align="center"><b>이메일</b></td>
							<%-- 
							<td>
								<input type="text" name="email" value="<%=qna.getEmail()%>">
							</td>
							 --%>
						</tr>

						<tr>
							<td width="20%" align="center"><b>제목</b></td>
							<td colspan="3">
								<input type="text" name="subject" value="<%=qna.getQna_title()%>" size="40">
							</td>
						</tr>
						<tr height="100">
							<td width="20%" align="center"><b>글내용</b></td>
							<td colspan="3">
								<textarea rows="7" cols="50" name="content">
									<%=qna.getContent()%>
								</textarea>
							</td>
						</tr>
<%-- 
						<tr>
							<td width="20%" align="center"><b>첨부파일</b></td>
							<td colspan="3"><%=qna.getFilename()%> (<%=qna.getFilesize()%>bytes)<br /> 
								<input type="file" name="filename">
							</td>
						</tr>
						 --%>
						<tr>
							<td colspan="4" align="center">
								<input type="button" value="수정하기" onclick="editCheck();"> 
								<input type="reset" value="다시쓰기">
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<a href="boardlist.bbs">목록</a>|
								<a href="boardEditForm.bbs?qna_num=<%=qna_num%>">편집</a> |
								<a href="boardDeletePassword.bbs?qna_num=<%=qna_num%>">삭제</a>|<a href="">답변</a>|
							</td>
						</tr>
					</table>
				</center>
			</form>
		</div>
	</div>
</body>
</html>