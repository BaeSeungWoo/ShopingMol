<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section class="py-5">
	<div class="container">
		<h2>공지사항 작성</h2>
		<br /> <label>작성자</label> <input type='text' name='writer' id="writer"
			value="${p.username}" readonly="readonly"> <br /> <br /> <label>제목</label>
		<input type='text' name='subject' id="subject" size='70'> <br />
		<br />
		<textarea rows="20" cols="90" name='contents' id="contents"></textarea>
		<br />
		<div class="row justify-content-end">
			<div class="col">
				<button type = "button" class="form-control btn btn-primary" id='btnInsert'
					name="btnInsert">저장</button>
			</div>
			<div class="col">
				<button type = "button" class="form-control btn btn-primary" id='btnCancel'
					name="btnCancel">취소</button>
			</div>
		</div>
	</div>
</section>

<script>
  $("#btnInsert").click(function(){
	  data = {
			  subject : $("#subject").val(),
			  contents : $("#contents").val()
	  }
	  if (!confirm("등록하시겠습니까?")){
		 return false;
	  } else {	 
		  $.ajax({
			  type : "post",
				url : "/admin/writeNotice/${p.username}",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(data)
		  })
		  .done(function(resp){
			  if(resp == "success"){
				  location.href = "/notice"
			  }
		  }) 
	  }
  })

</script>

<%@include file="../include/footer.jsp"%>
