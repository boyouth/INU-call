<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/find.css">
</head>
<body>
<script>
	function click_find_id(){
		var form = document.fm;
		
		if(!form.name.value){
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
					<form action="${root }user/find_id_ok" method="post" class="fm" id="fm" name="fm">
						<div class="title_find_id">아이디 찾기</div>

						<div class="note">회원 가입 시 입력한 본인 정보를 입력해주세요.</div>

						<div>
							<div>
								<label for="name" class="label-name">이름</label>
							</div>
							<div>
								<input type="text" name="name" id="name">
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
							<button type="button" class="btn-find" onclick="click_find_id()">찾아보기</button>
						</div>


					</form>



				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>