<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>


<head>
<meta charset="UTF-8">
</head>


<!--header-->
<div class="header">
	<nav>

		<div>

			<ul class="nav-container">
				<div class="img-clock">
					<a href="${root }main"><img
						src="https://img.icons8.com/offices/30/000000/clock.png" /></a>
				</div>
				<div class="menu">
					<li class="nav-item"><a href="">list1</a></li>
					<li class="nav-item"><a href="">list2</a></li>
					<li class="nav-item"><a href="">list3</a></li>
				</div>
				<div class="user">
					<c:choose>
						<c:when test="${empty loginUserInfo }">
							<li class="nav-item"><a href="${root }user/login">login</a></li>
							<li class="nav-item"><a href="${root }user/join">join</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a href="${root }user/logout">logout</a></li>
						</c:otherwise>
					</c:choose>
				</div>
			</ul>

		</div>
	</nav>
</div>