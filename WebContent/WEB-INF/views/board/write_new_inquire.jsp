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
		function cancel() {
			location.href = "${root}board/inquire_board";
		}
		function inq_list(){
			location.href = "${root}board/inquire_board";
		}
	</script>
	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">
					<div class="content_write">
						<div class="sort">문의 작성하기</div>
						<hr>
						<div class="content_write_list">
							<form action="${root }board/write_inquire_ok" method="post">
								<input type="hidden" value="${loginUserInfo.user_id }"
									name="user_id" id="user_id" />
								<div>
									<div style="padding-bottom: 10px;">
										<select name="type">
											<option value="미선택">문의유형</option>
											<option value="번호추가">번호추가</option>
											<option value="번호수정">번호수정</option>
											<option value="잘못된번호">잘못된번호</option>
											<option value="기타">기타</option>
										</select>
									</div>
									<div class="label-tit">
										<label for="title">문의제목</label>
									</div>
									<div class="tit" style="padding-bottom: 10px;">
										<input type="text" name="title" id="title" size="55">
									</div>
								</div>
								<div class="inq_note" style="padding-bottom: 10px;">
									<span style="color: #8904B1">"문의 내용"</span>에는
									<div>1. 전화번호 변동사항(추가된 정보, 수정되어야 하는 정보, 잘못된 전화번호 등록)에 대하여
										작성해 주세요.</div>
									<div>2. 자유게시판 게시글 중 게시판 성격과 맞지 않는 글의 제목과 작성자명 그리고 사유를
										작성해주세요.</div>
									<div>3. 기타 : 관리자가 개선했으면 하는 사항에 대해 작성해주세요.</div>

								</div>
								<div class="content_write_con">
									<div class="label-con">
										<label for="content">내용</label>
									</div>
									<div class="con" style="padding-bottom: 10px;">
										<textarea name="content" id="content" rows="5" cols="57"></textarea>
									</div>
								</div>
								<div class="btn-write" style="padding-bottom: 40px;">
									<input type="submit" value="작성하기"> <input type="button"
										value="취소" onclick="cancel()">
								</div>
								<div class="inq_list_for_user">
									<input type="button" value="문의목록" onclick="inq_list()">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>