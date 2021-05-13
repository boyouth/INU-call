<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/login.css">
</head>
<body>
<c:import url="/WEB-INF/views/include/header.jsp"/>
	<div class="wrapper">

		<form action="${root }user/login_ok" method="post">
			<div class="title_login">Login</div>


			<div>
				<div>
					<label for="id" class="label-id">Username</label>
				</div>
				<div>
					<input type="text" name="user_id">
				</div>
			</div>

			<div>
				<div>
					<label for="pw" class="label-pw">Password</label>
				</div>
				<div>
					<input type="password" name="user_pw">
				</div>
			</div>
			<div class="forgot_pw">
				<a href="">비밀번호를 잊으셨나요?</a>
			</div>
			<div class="btn">
				<button type="submit" class="btn btn-login">로그인</button>
				<div class="join-btn"><a href="${root }user/join">회원가입</a></div>
			</div>

		</form>
	</div>
	<c:import url="/WEB-INF/views/include/footer.jsp"/>
</body>

</html>