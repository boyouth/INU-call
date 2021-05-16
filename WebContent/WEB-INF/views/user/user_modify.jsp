<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/join.css">
<script type="text/javascript" src="${root }js/jquery-3.6.0.min.js"></script>

</head>
<script>
	function click_modify() {

		var form = document.user_mod;

		if (!form.user_pw.value) {
			alert("비밀번호를 입력하세요");
			return false;
		} else if (form.user_pw.value != form.user_pw_check.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;

		} else if (!form.email.value) {
			alert("이메일을 입력하세요.");
			return false;

		} else {
			document.getElementById('user_mod').submit();
		}

	}
</script>
<body>
<c:import url="/WEB-INF/views/include/header.jsp" />
	<div class="wrapper">

		<form action="${root }user/user_modify_ok" method="post" name="user_mod" id="user_mod">
			<div class="title_login">회원정보수정</div>


			<div>
				<div>
					<label for="id" class="label">Username</label>
				</div>
				<div>
					<input type="text" name="user_id" value="${loginUserInfo.user_id }" readonly="readonly">
				</div>
			</div>

			<div>
				<div>
					<label for="id" class="label">Name</label>
				</div>
				<div>
					<input type="text" name="user_name" value="${loginUserInfo.user_name }" readonly="readonly">
				</div>
			</div>

			<div>
				<div>
					<label for="pw" class="label">Password</label>
				</div>
				<div>
					<input type="password" name="user_pw">
				</div>
			</div>

			<div>
				<div>
					<label for="pw" class="label">Password check</label>
				</div>
				<div>
					<input type="password" name="user_pw_check">
				</div>
			</div>

			<div>
				<div>
					<label for="id" class="label">Email</label>
				</div>
				<div>
					<input type="text" name="email" value="${loginUserInfo.email }" placeholder="예) abc@inu.ac.kr">
				</div>
			</div>

			<div>
				<div>
					<label for="id" class="label">Phone</label>
				</div>
				<div>
					<select name="phone1">
						<option value="010" selected>010</option>
						<option value="011">011</option>
						<option value="017">017</option>
					</select> <input type="text" name="phone2" size="12" value="${phone }" placeholder="숫자만">
				</div>
			</div>

			<div class="btn">
				<button type="button" class="btn btn-login" onclick="click_modify()" id="reg_submit">정보수정</button>
			</div>
		</form>
	</div>
<c:import url="/WEB-INF/views/include/footer.jsp" />
</body>

</html>