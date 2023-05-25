<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section class="py-5">
	<div class="container">
		<h2>회원가입</h2>
		<div>
			<label for="username">아이디</label> <input class="form-control"
				type="text" id="username" name="username">
		</div>
		<br />
		<div>
			<label for="password">비밀번호</label> <input class="form-control"
				type="text" id="password" name="password">
		</div>
		<br />
		<div>
			<label for="passwordCheck">비밀번호 확인</label> <input
				class="form-control" type="text" id="passwordCheck"
				name="passwordCheck">
		</div>
		<br />
		<div>
			<label for="birth">생년월일</label> <input class="form-control"
				type="text" id="birth" name="birth">
		</div>
		<br />
		<div>
			<label for="age">나이</label> <input class="form-control" type="text"
				id="age" name="age">
		</div>
		<br />
		<div>
			<label for="phone">휴대전화</label> <input class="form-control"
				type="text" id="phone" name="phone">
		</div>
		<br />
		<div>
			<label>주소</label>
			<div class="row">
				<div class="col">
					<input class="form-control" type="text" id="zipcode" name="zipcode"
						placeholder="우편번호" readonly="readonly">
				</div>
				<div class="col-2">
					<input class="form-control btn btn-primary" type="button"
						onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col">
					<input class="form-control" type="text" id="address1"
						name="address1" placeholder="도로명주소" readonly="readonly">
				</div>
				<div class="col" style="display: none;">
					<span class="form-control" id="guide"
						style="color: #999; display: none"></span>
				</div>
				<div class="col">
					<input class="form-control" type="text" id="address2"
						name="address2" placeholder="상세주소">
				</div>
			</div>
		</div>
		<br />
		<div>
			<label>성별</label> 남 : <input type="radio" name="gender" value="man" />
			여 : <input type="radio" name="gender" value="woman" /><br />
		</div>
		<br />
		<div class="col">
			<input class="form-control btn btn-primary" type="submit" id="SignUp"
				value="회원가입"></input>
		</div>
	</div>
</section>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample4_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var extraRoadAddr = ''; // 참고 항목 변수

				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraRoadAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraRoadAddr += (extraRoadAddr !== '' ? ', '
							+ data.buildingName : data.buildingName);
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('zipcode').value = data.zonecode;
				document.getElementById("address1").value = roadAddr;

				var guideTextBox = document.getElementById("guide");
				// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
				if (data.autoRoadAddress) {
					var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
					guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr
							+ ')';
					guideTextBox.style.display = 'block';
					guideTextBox.parentNode.style.display = 'block';

				} else if (data.autoJibunAddress) {
					var expJibunAddr = data.autoJibunAddress;
					guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr
							+ ')';
					guideTextBox.style.display = 'block';
					guideTextBox.parentNode.style.display = 'block';
				} else {
					guideTextBox.innerHTML = '';
					guideTextBox.style.display = 'none';
					guideTextBox.parentNode.style.display = 'none';
				}
			}
		}).open();
	}
</script>
<%@include file="../include/footer.jsp"%>