<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성하기</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/table.css">
</head>
<body>
<script>
	function cancel(){
		location.href="${root}board/phone_book";
	}
</script>
	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">
					<div class="content_write">
						<div class="sort">작성하기</div>
						<hr>
						<div class="content_write_list">
							<form action="${root }board/write_phone_ok" method="post">
								<input type="hidden" value="${loginUserInfo.user_id }"
									name="user_id" id="user_id" />
								<div>
									<div class="label-tit">
										<label for="title">제목(학과명)</label>
									</div>
									<div class="tit">
										<input type="text" name="title" id="title" size="55">
									</div>
								</div>
								<div class="content_write_con">
									<div class="label-con">
										<label for="content">내용</label>
									</div>
									<div class="con">
										<textarea name="content" id="content" rows="5" cols="57"></textarea>
									</div>
								</div>
								<!-- <div>
								<div class="file">
									<input type="file" name="document" id="document">
								</div>
							</div> -->
								<div class="btn-write">
									<input type="submit" value="작성하기">
									<input type="button" value="취소" onclick="cancel()">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>