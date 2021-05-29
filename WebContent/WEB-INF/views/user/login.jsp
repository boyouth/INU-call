<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/login.css">
</head>
<body>
	<script>
		function click_login() {
			var form = document.login_info;

			if (!form.user_id.value) {
				alert("아이디를 입력하세요.");
				return false;
			} else if (!form.user_pw.value) {
				alert("비밀번호를 입력하세요.");
				return false;
			} else {
				document.getElementById('login_info').submit();
			}

		}
		
	</script>

	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">
					<form action="${root }user/login_ok" method="post"
						name="login_info" id="login_info" class="fm">
						<div class="title_login">로그인</div>


						<div class="username">
							<div>
								<label for="id" class="label-id">Username</label>
							</div>
							<div>
								<input type="text" name="user_id">
							</div>
						</div>

						<div class="userpw">
							<div>
								<label for="pw" class="label-pw">Password</label>
							</div>
							<div>
								<input type="password" name="user_pw">
							</div>
						</div>
						<div class="forgot_pw">
							<div>
								<a class="find_pw" href="${root }user/find_id">아이디를 잊으셨나요?</a>
							</div>
						</div>
						<div class="btn">
							<button type="button" class="btn btn-login"
								onclick="click_login()">로그인</button>
							<div class="join-btn">
								<a href="${root }user/join">회원가입</a>
							</div>
						</div>

					</form>



				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>