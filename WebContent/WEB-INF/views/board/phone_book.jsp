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
	<script>
		function write_new() {
			location.href = "${root}board/write_new_phone";
		}
		function write_new_phone() {
			location.href = "${root}board/write_new_inquire";
		}
	</script>
	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">

					<div class="content_list">
						<div class="sort">전화번호부</div>
						<!--게시판 이름-->
						<div></div>
						<hr>
						<c:if test="${loginUserInfo.user_id == 'admin' }">
							<div class="btn-new">
								<input type="button" onclick="write_new()" value="글쓰기">
							</div>
						</c:if>
						<c:if test="${loginUserInfo.user_id != 'admin'}">
							<div class="btn-new">
								<input type="button" onclick="write_new_phone()"
									value="전화번호추가 문의하기">
							</div>
						</c:if>


						<div class="divTable" style="width: 100%; border: 0px solid gray">
							<div class="divTableBody">
								<div class="divTableRow_tit">
									<div class="divTableCell">번호</div>
									<div class="divTableCell">부서</div>
									<!-- 부서 일 경우 부서(전화번호)를 표시!-->
									<div class="divTableCell">작성자</div>
									<div class="divTableCell">날짜</div>
								</div>

								<c:forEach var="item" items="${phone_book}">
									<!--  forEach로 데이터베이스가져오기 -->
									<c:set var="cnt" value="${cnt+1 }" />
									<div class="divTableRow">
										<div class="divTableCell">${cnt}</div>
										<div class="divTableCell">
											<a
												href="${root }board/phone_book_read?list_idx=${item.list_idx}">${item.list_depart }</a>
										</div>
										<div class="divTableCell">${item.list_writer_name }</div>
										<div class="divTableCell">${item.list_date }</div>
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