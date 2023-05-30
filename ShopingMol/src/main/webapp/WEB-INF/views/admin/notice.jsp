<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section class="py-5">
	<div class="container">
		<h2>공지사항</h2>
		<table class="table">
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회 수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${notice }" var="notice">
				<tr>
					<td>${notice.subject }</td>
					<td>${notice.customer.name }</td>
					<td><fmt:formatDate value = "${notice.regDate }" pattern="yyyy/MM/dd"/></td>
					<td>${notice.count }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<sec:authorize access = "hasRole('ADMIN')">
		<form action = "/admin/writeNotice" method = "get">
		<div class="col-1">
			<input class="form-control btn btn-primary" type="submit" id="writeNotice"
				value="작성"></input>
		</div>
		</form>
		</sec:authorize>
	</div>
</section>
<%@include file="../include/footer.jsp"%>