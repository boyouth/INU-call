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
		function del() {
			if (confirm("삭제하시겠습니까?")) {
				location.href = "${root}board/inquire_board_delete?inquire_idx=${inquire_idx}"
			} else {
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
						<div class="tit">${inquire_info.inquire_type }|
							${inquire_info.inquire_title }</div>
						<div class="writer">| ${inquire_info.inquire_writer_name }</div>
						<div class="date">| 날짜 ${inquire_info.inquire_date }</div>

					</div>
					<hr style="border: 1px color=silver;">
					<c:if
						test="${loginUserInfo.user_id == inquire_info.inquire_writer_id }">
						<div class="edit">
							<input type="button" value="삭제하기" onclick="del()" />
						</div>
					</c:if>
					<div class="note"></div>

					<div class="list_content">
						<div>${inquire_info.inquire_content }</div>

					</div>
					<hr style="border: 1px color=silver;">
					<div style="text-align: right">
						<a href="${root }board/inquire_board">목록으로</a>
					</div>



					<div class="list_comment">
						<!-- 답변다는곳. -->
						<div class="comment-img">
							<img src="https://img.icons8.com/small/16/000000/topic--v1.png" />
							${empty1 }
						</div>
						<div class="user_name">${inquire_comment.comment_writer }</div>
						<div class="reply">${inquire_comment.inquire_comment}</div>
					</div>
					<!-- 관리자만 작성 가능 -->
					<c:if test="${loginUserInfo.user_id == 'admin' }">
						<div class="list_comment_write">
							<form action="${root }board/write_comment_inq" method="post">
								<input type="hidden" value="${inquire_idx }" name="inquire_idx" />
								<div>
									<textarea id="comment" name="comment" rows="2" cols="60"></textarea>
								</div>

								<div class="btn-comment">
									<input type="submit" value="작성하기">
								</div>
							</form>

						</div>
					</c:if>




				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

	</div>