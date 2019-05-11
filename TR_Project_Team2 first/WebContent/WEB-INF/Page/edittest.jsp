<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action ="editok.Schedule" method = "post">
	글번호<input type ="text" id = "num" name = "num" value ="${list.cl_num }" readonly><br>
	작성자<input type ="text" id = "id" name = "id" value = "${list.id}" readonly><br>
	title<input type ="text" id = "title" name = "title" value = "${list.cl_title }"><br>
	color<input type ="text" id = "color" name = "color" value = "${list.color }"><br>
	<input type ="submit">
</form>

<h3>된건가;</h3>