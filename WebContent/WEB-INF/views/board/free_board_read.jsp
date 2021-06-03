<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>전화번호부</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/table.css">
</head>
<body>
	<script>
	function edit(){
		location.href="${root}board/free_board_edit?title=${free_info.free_title}&free_idx=${free_idx}"
	}
	
	function del(){
		if(confirm("삭제하시겠습니까?")){
			location.href="${root}board/free_board_delete?free_idx=${free_idx}"
		}
		else{
			location.reload();
		}
	}
	
	// 좋아요 누르는 경우.
	function agree(){
		var like = $("#likey").html();
		if(like == 0){
			var form = {
	                free_idx: ${free_idx},
	                user_id:"${loginUserInfo.user_id}",
	                likey: 1
	        }
		}
		else if(like == 1){
			var form = {
	                free_idx: ${free_idx},
	                user_id: "${loginUserInfo.user_id}",
	                likey: 0
	        }
		}		
        $.ajax({
            url: "${root}board/free_like",
            type: "POST",
            data: form,
            success: function(data){
                $('#likey').html(data);
                if(like==0){
                	$("#heart").attr("src", "https://img.icons8.com/material-rounded/24/4a90e2/filled-like.png");
                }
                else if(like==1){
                	$("#heart").attr("src", "https://img.icons8.com/material-outlined/24/4a90e2/filled-like.png");

                }
            },
            error: function(){
                alert("err");
            }
        });
    }
	
	
</script>
	<div class="wrapper">
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div>

			<div class="content">
				<c:import url="/WEB-INF/views/sub.jsp" />
				<div class="main">

					<div class="list_title">
						<div class="tit">${free_info.free_title }</div>
						<div class="writer">| ${free_info.free_writer_name }</div>
						<div class="hit">| 조회수 ${free_info.free_hit }</div>
						<div class="date">| 날짜 ${free_info.free_date }</div>

					</div>
					<hr style="border: 1px color=silver;">
					<c:if test="${loginUserInfo.user_id == free_info.free_writer_id }">
						<div class="edit">
							<input type="button" value="수정하기" onclick="edit()" /> <input
								type="button" value="삭제하기" onclick="del()" />
						</div>
					</c:if>
					<div class="note">
						<div style="font-size: 10px; color: gray;">
							본인의 글은 <span style="color: red;">직접 삭제</span>가 가능합니다.
						</div>
						<!-- 자유게시판 -->
					</div>

					<div class="list_content">
						<div>${free_info.free_content }</div>

					</div>
					<hr style="border: 1px color=silver;">


					<div class="btn-like">
						<a href="javascript:void(0);" onclick="agree()">
							<div id="likey" name="likey" class="likey">
							${like }
							</div>
							<c:if test="${like == 0 }">
							<img id="heart" src="https://img.icons8.com/material-outlined/24/4a90e2/filled-like.png"/>
							</c:if>
							<c:if test="${like == 1 }">
							<img id="heart" src="https://img.icons8.com/material-rounded/24/4a90e2/filled-like.png"/>
							</c:if>
							
						</a>

						<div id="all_likes" class="all_likes">${count_like }</div>
					</div>

					<hr>
					<c:if test="${empty1 != ''}">
						<img src="https://img.icons8.com/small/16/000000/topic--v1.png" />
							${empty1 }
					</c:if>
					<c:forEach var="item3" items="${free_comment }">
						<div class="list_comment">
							<div class="comment-img">
								<img src="https://img.icons8.com/small/16/000000/topic--v1.png" />
							</div>
							<div class="user_name">${item3.comment_writer }</div>
							<span class="datetime">| ${item3.comment_date }</span>
							
							<div class="reply">${item3.free_comment}</div>
						</div>
					</c:forEach>
					<div class="list_comment_write">
						<form action="${root }board/write_comment_free" method="post">
							<input type="hidden" value="${free_idx }" name="free_idx" />
							<div>
								<textarea id="comment" name="comment" rows="2" cols="60"></textarea>
							</div>

							<div class="btn-comment">
								<input type="submit" value="작성하기">
							</div>
						</form>
					</div>


				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

	</div>