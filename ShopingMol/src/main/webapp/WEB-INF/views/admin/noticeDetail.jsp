<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section>
	<div class="container">
		<h2>공지사항</h2>
		<table class="table table-hover" style="text-align: center;">
			<tr>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회 수</th>
			</tr>
			<tr>
				<td>${notice.subject}</td>
				<td>${notice.customer.name}</td>
				<td>${notice.regDate}</td>
				<td>${noticeCount}</td>
			</tr>
		</table>
		<br />
		<div class="row justify-content-end">
			<textarea rows="20" cols="90" name='contents' id="contents" disabled>${notice.contents}</textarea>
		</div>
		<br />
		<c:if test="${p.user.num == notice.customer.num}">
			<div class="row justify-content-end">
				<div class="col-9"></div>
				<div class = "col">
					<button type="button" class="form-control btn btn-primary"
						id='btnModify' name="btnModify">수정</button>	
				</div>
				<div class="col">
				<button type="button" class="form-control btn btn-primary"
						id='btnDelete' name="btnDelete">삭제</button></div>
			</div>
		</c:if>
		<br />
	</div>
</section>
<script>
  $("#btnModify").click(function(){
	  location.href = "/admin/noticeModifyForm/${notice.id}"
  })
  $("#btnDelete").click(function(){
	  if(!confirm("정말 삭제하시겠습니까?")){
		  return false;
	  } else {
		  $.ajax({
			  type : "delete",
			  url : "/admin/delete/${notice.id}"
		  })
		  .done(function(resp) {
			  alert("삭제에 성공하였습니다.")
			  location.href = "/notice"
		  })
	  }
  })
</script>
<%@include file="../include/footer.jsp"%>