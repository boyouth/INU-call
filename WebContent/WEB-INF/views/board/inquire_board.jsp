<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의게시판</title>
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

					<div class="content_list">
						<div class="sort">문의게시판</div>
						<!--게시판 이름-->
						<hr>
						<c:if test="${not empty loginUserInfo}">
						<div class="btn-new"><input type="button"  value="글쓰기">
						</div>
						</c:if>
						<div class="divTable" style="width: 100%; border: 0px solid gray">
							<div class="divTableBody">
								<div class="divTableRow_tit">
									<div class="divTableCell">번호</div>
									<div class="divTableCell">유형</div>
									<div class="divTableCell">문의제목</div>
									<!-- 부서 일 경우 부서(전화번호)를 표시!-->
									<div class="divTableCell">작성자</div>
									<div class="divTableCell">날짜</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">1</div>
									<div class="divTableCell">오타</div>
									<div class="divTableCell">
										<a href="">경영학부 야간 과사 오타 수정바래요.</a>
									</div>
									<div class="divTableCell">경영노예</div>
									<div class="divTableCell">2021-05-14</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">2</div>
									<div class="divTableCell">추가</div>
									<div class="divTableCell">
										<a href="">과사 전화 하나 더생김요</a>
									</div>
									<div class="divTableCell">인천대인31</div>
									<div class="divTableCell">2021-05-16</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">3</div>
									<div class="divTableCell">기타</div>
									<div class="divTableCell">
										<a href="">총장님 아들 전화번호도 공개해주셈</a>
									</div>
									<div class="divTableCell">찐따</div>
									<div class="divTableCell">2021-05-16</div>
								</div>
							</div>
						</div>

					</div>


				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

	</div>
	<!--  -->