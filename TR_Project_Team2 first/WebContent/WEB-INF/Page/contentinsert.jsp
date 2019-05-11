<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>추가할 내용</h3>
<hr>
<form action="writeContentOk.Checklist?num=${num }" method="post">
<input type = "text" id = "content" name = "content" placeholder="내용을 입력해주세요.(50)" width = 500px height= "100px">
<input type = "submit" value="추가 하기">
</form>
뭐지 이건 ${num}