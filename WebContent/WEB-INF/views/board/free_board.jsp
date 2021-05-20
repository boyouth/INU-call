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
<script>
	function write_new(){
		location.href="${root}board/write_new_free";
	}
</script>
	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">

					<div class="content_list">
						<div class="sort">자유게시판</div>
						<!--게시판 이름-->
						<hr>
						<c:if test="${not empty loginUserInfo}">
						<div class="btn-new"><input type="button" onclick="write_new()"  value="글쓰기">
						</div>
						</c:if>
						<div class="divTable" style="width: 100%; border: 0px solid gray">
							<div class="divTableBody">
								<div class="divTableRow_tit">
									<div class="divTableCell">번호</div>
									<div class="divTableCell">제목</div>
									<!-- 부서 일 경우 부서(전화번호)를 표시!-->
									<div class="divTableCell">작성자</div>
									<div class="divTableCell">날짜</div>
								</div>
								<c:forEach var="item" items="${free_board}" > <!--  forEach로 데이터베이스가져오기 -->
								<c:set var="cnt" value="${cnt+1 }" />
								<div class="divTableRow">
									<div class="divTableCell">${cnt}</div>
									<div class="divTableCell">
										<a href="${root }board/free_board_read?free_idx=${item.free_idx}">${item.free_title}</a>
									</div>
									<div class="divTableCell">${item.free_writer_name }</div>
									<div class="divTableCell">${item.free_date }</div>
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