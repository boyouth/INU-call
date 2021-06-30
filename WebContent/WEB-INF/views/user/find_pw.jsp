<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/find.css">
</head>
<body>
<script>
	function click_find_pw(){
		var form = document.fm;
		
		if(!form.user_id.value){
			alert("아이디를 입력하세요.");
			return false;
		}
		else if(!form.user_name.value){
			alert("이름를 입력하세요.");
			return false;
		}
		else if(!form.email.value){
			alert("이메일을 입력하세요.");
			return false;
		}
		else{
			document.getElementById('fm').submit();
		}
		
	}
</script>

	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">
					<form action="${root }user/find_pw_ok" method="post" class="fm" name="fm" id="fm">
					<input type="hidden" name="check" id="check" value="findpw" />
						<div class="title_find_id">비밀번호 찾기</div>

						<div class="note">회원 가입 시 입력한 본인 정보를 입력해주세요.</div>
						<div>
							<div>
								<label for="id" class="label-id">아이디</label>
							</div>
							<div>
								<input type="text" name="user_id" id="user_id">
							</div>
						</div>

						<div>
							<div>
								<label for="name" class="label-name">이름</label>
							</div>
							<div>
								<input type="text" name="user_name" id="user_name">
							</div>
						</div>

						<div>
							<div>
								<label for="email" class="label-email">이메일</label>
							</div>
							<div>
								<input type="text" name="email" id="email">
							</div>
						</div>
						<div class="btn">
							<button type="button" class="btn-find" onclick="click_find_pw()">임시비밀번호 발급받기</button>
						</div>
						<div class="home">
							<a href="${root }main">메인으로</a>
						</div>
					</form>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>