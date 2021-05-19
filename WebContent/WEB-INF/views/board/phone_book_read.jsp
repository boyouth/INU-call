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
		location.href="${root}board/phone_book_edit?title=${list_info.list_depart}&list_idx=${list_idx}"
	}
	
	function del(){
		if(confirm("삭제하시겠습니까?")){
			location.href="${root}board/phone_book_delete?list_idx=${list_idx}"
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
						<div class="tit">${list_info.list_depart } 전화번호</div>
						<div class="writer">| ${list_info.list_writer_name }</div>
						<div class="hit">| 조회수 0</div>
						<div class="date">| 날짜 ${list_info.list_date }</div>
						
					</div>
					<hr style="border: 1px color=silver;">
					<c:if test="${loginUserInfo.user_id == list_info.list_writer_id }">
					<div class="edit">
					<input type="button" value="수정하기" onclick="edit()"/>
					<input type="button" value="삭제하기" onclick="del()"/>					
					</div>
					</c:if>
					<div class="note">
						<div  style="color: #B40431;">잘못된 전화번호가 등록되었거나 변경되었다면 문의게시판에 남겨주세요.</div><!-- 전화번호부 -->
						<!-- <div>
							본인의 글은 <span style="color: red;">직접 삭제</span>가 가능합니다.
						</div> -->
						<!-- 자유게시판 -->
					</div>

					<div class="list_content">
						<div>${list_info.list_content }</div>

					</div>
					<hr style="border: 1px color=silver;">


					<div class="btn-emotion">
						<input type="button" value="좋아요"> <input type="button"
							value="친절해요"> <input type="button" value="불친절해요">
					</div>

					<hr>
					<div class="list_comment">
						<div class="comment-img">
							<img src="https://img.icons8.com/small/16/000000/topic--v1.png" />
						</div>
						<div class="user_name">젤리</div>
						<div class="reply">친절하세요.</div>
					</div>
					<div class="list_comment_write">
						<div>
							<textarea id="comment" name="comment" rows="2" cols="60"> 
    						</textarea>
						</div>
						<div class="btn-comment">
							<input type="button" value="작성하기">
						</div>
					</div>


				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

	</div>