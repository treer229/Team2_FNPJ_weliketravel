<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
    $('input[name=edit]').click(function(){
          var index = $('input[name=edit]').index(this);
          var url = $('#editform').attr('action');
          var cl_num = $("input[name=editnum]").eq(index).val();
          console.log('cl_num : ' + cl_num );
          
          
          $.ajax({
              url : url,
              data : {cl_num:cl_num},
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
              data : {cl_num:$('input[name=delnum]').eq(index).val()},
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
<%-- <div id = "listmain">
<table border="1">
	<thead><th>글번호 </th><th>글 제목</th><th>색상</th><th>아이디</th><th>수정</th><th>삭제</th></thead>
	<tbody>
	<c:forEach var ="i" items="${list }">
	<tr><td>${i.cl_num }</td><td><a href = "CheckContent.Checklist?num=${i.cl_num }" id = "contents">${i.cl_title }</a></td><td>${i.color }</td><td>${i.id }</td>
	<td>
	
	<form action="edit.Checklist" method ="post" id = "editform" name = "editform">
	<input type ="button" id = "edit" name ="edit" value ="수정">
	<input type ="hidden" id="editnum${var.index }" name="editnum${var.index }" value = "${i.cl_num }">
	</form>
	</td>
	<td>
	<form action="del.Checklist" method ="post" id="delform" name="delform">
	<input type = "button" id ="del" name = "del" value ="삭제">
	<input type ="hidden" id="delnum${var.index }" name="delnum${var.index }" value = "${i.cl_num }">
	
	</form>
	</td>
	</tr>
	</c:forEach>
	</tbody>
</table> </div>
--%>

<table>
	<tr>
	<th>아뒤 </th><th>글</th><th>날짜</th>
	</tr>
	<c:forEach var ="i" items="${notilist}">
	<tr><td>${i.id }</td><td>${i.comments_content }</td><td>${i.comments_date }</td></tr>
	</c:forEach>
</table>
