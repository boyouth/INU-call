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
	function edit(){
		location.href="${root}board/phone_book_edit?" 
	}
	
	function del(){
		if(confirm("삭제하시겠습니까?")){
			location.href="${root}board/phone_book_delete?"
		}
		else{
			location.reload();
		}
	}
</script>
	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">

					<div class="list_title">
						<div class="tit">${school } 전화번호</div>
					</div>
					<hr style="border: 1px color=silver;">
					
					<div class="note">
						<div  style="color: #B40431;font-size:10px">잘못된 전화번호가 등록되었거나 변경되었다면 문의게시판에 남겨주세요.</div><!-- 전화번호부 -->
						<!-- <div>
							본인의 글은 <span style="color: red;">직접 삭제</span>가 가능합니다.
						</div> -->
						<!-- 자유게시판 -->
					</div>

					<div class="list_content">
					<c:forEach var="item" items="${ majors}">
						<div>${item.major} | <span style="color:#8000FF">${item.phone }</span> - ${item.commentary }</div>
					</c:forEach>
						

					</div>
					<hr style="border: 1px color=silver;">


					<div class="btn-like"> <input type="button"
							value="친절해요">
					</div>

					<hr>
					<div style="text-align:right"><a href="${root}board/phone_book">목록으로</a></div>


				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

	</div>