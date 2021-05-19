<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/table.css">

</head>
<body>
	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">

					<div class="main-slogan">

						<div>몰랐다고 하는 것은 여기까지만 하자.</div>
						<div>넌 이제 중학생, 고등학생이 아닌 대학생이다.</div>
						<div>
							망설이지 말고 <span class="doit">전화하라.</span>
						</div>
						<div class="goal">대학, 편하게 누리며 생활하자</div>
					</div>


				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

	</div>