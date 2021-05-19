<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />




<!--header-->
<div class="header">
	<nav>

		<div>

			<ul class="nav-container">
				<div class="img-clock">
					<a href="${root }main"><img src="${root}image/inu_call.PNG" /></a>
				</div>
				<div class="menu">
					<li class="nav-item"><a href="${root }board/phone_book">전화번호부</a></li>
					<li class="nav-item"><a href="${root }board/free_board">자유게시판</a></li>
					<li class="nav-item"><a href="${root }board/inquire_board">문의게시판</a></li>
				</div>
				<div class="user">
					<c:choose>
						<c:when test="${empty loginUserInfo }">
							<li class="nav-item"><a href="${root }user/login">로그인</a></li>
							<li class="nav-item"><a href="${root }user/join">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a href="">${loginUserInfo.user_name }님</a></li>
							<li class="nav-item"><a href="${root }user/user_modify">회원정보수정</a></li>
							<li class="nav-item"><a href="${root }user/logout">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
				</div>
			</ul>

		</div>
	</nav>
</div>