<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/join.css">
<script type="text/javascript" src="${root }js/jquery-3.6.0.min.js"></script>
</head>
<script>
	function click_join() {

		var form = document.userInfo;

		if (!form.user_id.value) {
			alert("아이디를 입력하세요");
			return false;
		} else if (!form.user_name.value) {
			alert("이름을 입력하세요");
		} else if (!form.user_pw.value) {
			alert("비밀번호를 입력하세요");
		} else if (form.user_pw.value != form.user_pw_check.value) {
			alert("비밀번호가 일치하지 않습니다.");
		} else if (!form.email.value) {
			alert("이메일을 입력하세요.");
		} else {
			document.getElementById('userInfo').submit();
		}

	}
</script>
<body>
	<script>
		$("#user_id").on('blur', function() { //왜 안될까?...
			var user_id = $('#user_id').val();

			if (user_id.length < 4) {
				$("#id_check").text("아이디가 너무 짧습니다. 4자리이상 입력해주세요.");
				$("#id_check").css("color", "red");
			}

			$.ajax({
				url : '${root}user/checkId?user_id=' + user_id,
				type : 'get',
				dataType : 'text',
				success : function(data) {

					if (data.trim() == 'true') {
						// 중복일 경우
						$("#id_check").text("사용중인 아이디입니다.");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					}

				},
				error : function() {
					console.log("실패");
				}
			});
		});
	</script>
	<c:import url="/WEB-INF/views/include/header.jsp" />
	<div class="wrapper">

		<form action="${root }user/join_ok" method="post" name="userInfo"
			id="userInfo">
			<div class="title_login">Join</div>
			<div>

				<div>
					<div>
						<label for="id" class="label">Username</label>
					</div>
					<div>
						<input type="text" name="user_id" id="user_id" required="required">
						<div id="id_check" style="font-size: 11px; color: red;"></div>
					</div>
				</div>

				<div>
					<div>
						<label for="id" class="label">Name</label>
					</div>
					<div>
						<input type="text" name="user_name">
					</div>
				</div>

				<div>
					<div>
						<label for="pw" class="label">Password</label>
					</div>
					<div>
						<input type="password" name="user_pw" required="required">
					</div>
				</div>

				<div>
					<div>
						<label for="pw" class="label">Password check</label>
					</div>
					<div>
						<input type="password" name="user_pw_check" required="required">
					</div>
				</div>

				<div>
					<div>
						<label for="id" class="label">Email</label>
					</div>
					<div>
						<input type="text" name="email" placeholder="예) abc@inu.ac.kr"
							required="required">
					</div>
				</div>

				<div>
					<div>
						<label for="id" class="label">Phone</label>
					</div>
					<div>
						<select name="phone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
						</select> <input type="text" name="phone2" size="12" placeholder="숫자만"
							required="required">
					</div>
				</div>
			</div>
			<div class="btn">
				<button type="button" class="btn btn-login" onclick="click_join()"
					id="reg_submit">회원가입</button>
			</div>

		</form>
	</div>
	<c:import url="/WEB-INF/views/include/footer.jsp" />
</body>
</html>