<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/table.css">
</head>
<body>
	<div class="content_list">
		<div class="sort">전화번호부</div>
		<!--게시판 이름-->
		<hr>
		<div class="divTable" style="width: 100%; border: 0px solid gray">
			<div class="divTableBody">
				<div class="divTableRow_tit">
					<div class="divTableCell">번호</div>
					<div class="divTableCell">부서</div>
					<!-- 부서 일 경우 부서(전화번호)를 표시!-->
					<div class="divTableCell">작성자</div>
					<div class="divTableCell">날짜</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell">1</div>
					<div class="divTableCell">
						<a href="">컴퓨터공학부 전화번호부</a>
					</div>
					<div class="divTableCell">관리자</div>
					<div class="divTableCell">2021-05-14</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell">2</div>
					<div class="divTableCell">
						<a href="">경영학 전화번호부</a>
					</div>
					<div class="divTableCell">관리자</div>
					<div class="divTableCell">2021-05-15</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell">3</div>
					<div class="divTableCell">
						<a href="">정보통신학과 전화번호부</a>
					</div>
					<div class="divTableCell">정통닝겐</div>
					<div class="divTableCell">2021-05-15</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>