<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section class="py-5">
	<div class="container">
		<h2>로그인</h2>
		<div>
			<label for="username">아이디</label> <input class="form-control"
				type="text" id="username" name="username">
		</div>
		<br />
		<div>
			<label for="username">비밀번호</label> <input class="form-control"
				type="text" id="password" name="password">
		</div>
		<br />
		<div class="row justify-content-end">
			<div class="col-10"></div>
			<div class="col">
				<input class="form-control btn btn-primary" type="submit"
					id="Login" value="로그인"></input>
			</div>
		</div>
	</div>
</section>
<%@include file="../include/footer.jsp"%>

<script>
	$("#Login").click(function() {
		if ($("#username").val() == "") {
			alert("아이디를 입력하세요")
			return false;
		}

		if ($("#password").val() == "") {
			alert("비밀번호를 입력하세요")
			return false;
		}
		
/* 		$.ajax({
			type : "post",
			url : "Login",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data)
		})
		.done(function(resp)) {
			alert("관리자로 로그인하셨습니다.")
			location.href = "/admin";
		} */
	})
</script>