<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/table.css">
</head>
<body>
	<div class="content_list">
		<div class="sort">자유게시판</div>
		<!--게시판 이름-->
		<hr>
		<div class="divTable" style="width: 100%; border: 0px solid gray">
			<div class="divTableBody">
				<div class="divTableRow_tit">
					<div class="divTableCell">번호</div>
					<div class="divTableCell">제목</div>
					<!-- 부서 일 경우 부서(전화번호)를 표시!-->
					<div class="divTableCell">작성자</div>
					<div class="divTableCell">날짜</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell">1</div>
					<div class="divTableCell">
						<a href="">기숙사 일처리 제대로 안하냐</a>
					</div>
					<div class="divTableCell">3긱생뎐</div>
					<div class="divTableCell">2021-05-14</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell">2</div>
					<div class="divTableCell">
						<a href="">확진자 또나옴 확인 ㄱㄱ</a>
					</div>
					<div class="divTableCell">인천대인1</div>
					<div class="divTableCell">2021-05-16</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell">3</div>
					<div class="divTableCell">
						<a href="">논문쓰는팁공유함.</a>
					</div>
					<div class="divTableCell">경영학닝겐</div>
					<div class="divTableCell">2021-05-16</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>