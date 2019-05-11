<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
    $('input[name=edit]').click(function(){
          var index = $('input[name=edit]').index(this);
          var url = $('#editform').attr('action');
          var schedule_num = $("input[name=editnum]").eq(index).val();
          console.log('schedule_num : ' + schedule_num );
          
          
          $.ajax({
              url : url,
              data : {schedule_num:schedule_num},
              type : "post",
              success : function(data){
                      $("#listmain").empty();
                      $("#listmain").append(data);
                      
              },
              error : function(xhr){
                  alert('이동 실패 : ' + xhr.status );
              }
          });
              
          
      });
      
      $('input[name=del]').click(function(){
          var index = ($('input[name=del]').index(this));
          var url = $('#delform').attr('action');
          console.log($('input[name=delnum]').eq(index).val());
          
          var check = confirm("정말로 삭제하시겠습니까?")
      
          if(check) {
              alert('삭제실행');
              console.log(check);
          }else {
                alert('삭제를 취소합니다.');
                return
          }
          
          $.ajax({
              url : url,
              data : {schedule_num:$('input[name=delnum]').eq(index).val()},
              type : "post",
              datatype : "html",
              success : function(data){
                  alert($('input[name=delnum]').eq(index).val() + "번 체크리스트 삭제 완료");
                      $("#listmain").empty();
                      $("#listmain").append(data);
              },
          
              error : function(xhr){
                  alert('삭제 실패 : ' + xhr.status );
              }
          });
          
          
      });
	});

</script>

<div id ="listmain">
<table border="1">
	<thead><tr><td>스케줄 번호</td> <td>제목</td> <td>내용</td> <td>작성자</td> <td>시작일</td> <td>종료일</td> <td>색상</td> <td>삭제여부</td> <td>완료여부</td></tr></thead>
		<tbody>
<c:forEach var = "i" items = "${list }">
	<tr>
	<td>${i.schedule_num}</td>
	<td>${i.schedule_title}</td>
	<td>${i.content}</td>
	<td>${i.id}</td>
	<td>${i.schedule_start}</td>
	<td>${i.schedule_end}</td>
	<td>${i.color}</td>
	<td>${i.deleteok}</td>
	<td>${i.completeok}</td>
	<td>
	
	<form action="edit.Schedule" method ="post" id = "editform" name = "editform">
	<input type ="button" id = "edit" name ="edit" value ="수정">
	<input type ="hidden" id="editnum${var.index }" name="editnum${var.index }" value = "${i.schedule_num}">
	</form>
	</td>
	<td>
	<form action="del.Schedule" method ="post" id="delform" name="delform">
	<input type = "button" id ="del" name = "del" value ="삭제">
	<input type ="hidden" id="delnum${var.index }" name="delnum${var.index }" value = "${i.schedule_num }">
	
	</form>
	</td>
	<tr>
	
</c:forEach>

		</tbody>
</table>
<a href = "insert.Schedule">추가하기</a>
</div>