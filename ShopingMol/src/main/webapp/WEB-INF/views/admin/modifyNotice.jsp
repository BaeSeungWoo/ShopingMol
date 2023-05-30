<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section>
	<div class="container">
		<h2>공지사항 수정</h2>
		<input type="hidden" id="id" name="id" value="${notice.id}">
		<table class="table table-hover">
			<tr>
				<th>제목</th>
			</tr>
			<tr>
				<td><input type="text" id="subject" name="subject"
					value="${notice.subject}" /></td>
			</tr>
		</table>
		<br />
		<div class="row justify-content-end">
			<h4>내용</h4>
			<textarea rows="20" cols="90" name='contents' id="contents">${notice.contents}</textarea>
		</div>
		<br />
		<div class="row justify-content-end">
			<div class="col-9"></div>
			<div class="col">
				<button type="button" class="form-control btn btn-primary"
					id='Modify' name="Modify">수정</button>
			</div>
			<div class="col">
				<button type="button" class="form-control btn btn-primary"
					id='Cancel' name="Cancel">취소</button>
			</div>
		</div>
		<br />
	</div>
</section>
<script>
	$("#Modify").click(function() {
		data = {
			id : $("#id").val(),
			subject : $("#subject").val(),
			contents : $("#contents").val()
		}
		$.ajax({
			type : "put",
			url : "/admin/Modify",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data)
		}).done(function(resp) {
			if (resp == "success") {
				location.href = "/notice"
			}
		})
	})
	
	$("#Cancel").click(function(){
		location.href = "/noticeDetail/${notice.id}"
	})
</script>
<%@include file="../include/footer.jsp"%>