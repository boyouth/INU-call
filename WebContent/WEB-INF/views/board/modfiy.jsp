<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<div class="content_modify">
		<div class="sort">게시글 수정하기</div>
		<hr>
		<div class="content_modify_list">
			<div>
				<div class="label-tit">
					<label for="title">제목</label>
				</div>
				<div class="tit">
					<input type="text" name="title" id="title" size="55"
						readonly="readonly">
				</div>
				<!-- 수정할 시 제목옆에 [수정] 글자 표시!!!-->
			</div>
			<div class="content_modify_con">
				<div class="label-con">
					<label for="content">내용</label>
				</div>
				<div class="con">
					<textarea name="content" id="content" rows="5" cols="57"></textarea>
				</div>
			</div>
			<div>
				<div class="file">
					<!--등록했던 파일 표시!!!-->
					<input type="file" name="document" id="document">
				</div>
			</div>
			<div class="btn-modify">
				<input type="button" value="수정하기">
			</div>
		</div>
	</div>
</body>
</html>