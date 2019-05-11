<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action ="editok.Schedule" method = "post">
	글번호  : <input type = "text" id="num" name = "num" value ="${schedule.schedule_num }" readonly><br>
	title : <input type = "text" id="title" name = "title" value ="${schedule.schedule_title }"><br>
	컨텐츠 : <input type = "text" id="content" name = "content" value ="${schedule.content }"><br>
	id : <input type = "text" id="id" name = "id" value ="${schedule.id }" readonly><br>
	시작할 날짜 : <input type = "text" id="start" name = "start" value ="${schedule.schedule_start }"><br>
	끝나는 날짜 : <input type = "text" id="end" name = "end" value ="${schedule.schedule_end }"><br>
	색상 : <input type = "text" id="color" name = "color" value ="${schedule.color }"><br>
	삭제 : <input type = "text" id="del" name = "del" value ="${schedule.deleteok }"><br>
	완료 : <input type = "text" id="com" name = "com" value ="${schedule.completeok }"><br>
	<input type ="submit" value = "수정하기">

</form>