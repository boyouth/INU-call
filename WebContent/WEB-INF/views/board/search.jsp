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

	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">

					<div class="content_list">
						<div class="sort">전체</div>
						<!--게시판 이름-->
						<div></div>
						<hr>
						


						<div class="divTable" style="width: 100%; border: 0px solid gray">
							<div class="divTableBody">
								<div class="divTableRow_tit">
									<div class="divTableCell">번호</div>
									<div class="divTableCell">대학</div>
									<div class="divTableCell">학과</div>
									<div class="divTableCell">전화번호</div>
									<div class="divTableCell">비고</div>
									<!-- 부서 일 경우 부서(전화번호)를 표시!-->
								</div>

								<c:forEach var="item" items="${result}">
									<!--  forEach로 데이터베이스가져오기 -->
									<c:set var="cnt" value="${cnt+1 }" />
									<div class="divTableRow">
										<div class="divTableCell">${cnt}</div>
										<div class="divTableCell">${item.school }</div>
										<div class="divTableCell">${item.major }</div>
										<div class="divTableCell">${item.phone}</div>
										<div class="divTableCell">${item.commentary}</div>
									</div>
								</c:forEach>
							</div>
						</div>
						
					</div>


				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

	</div>
	<!--  -->