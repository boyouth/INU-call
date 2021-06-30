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
<title>자유게시판</title>
<link rel="stylesheet" href="${root }css/index.css">
<link rel="stylesheet" href="${root }css/table.css">
</head>
<body>
	<script>
		function write_new() {
			location.href = "${root}board/write_new_free";
		}
		
		var btn = $(".pagination .page-item");
		btn.find("a").click(function(){
			btn.removeClass("active");
			$(this).parent().addClass("active");
		});
		
		
		
		function search_free(){
			var sort = document.getElementById('condition').value;
			var word = document.getElementById('srch_f').value;
			
			if(word == ''){
				alert("자유게시판::검색어를 입력해주세요.");
				return false;
			}
			
			location.href="${root}board/search_free?sort="+sort+"&word="+word;
		}
		
		function enterkey_3(){
			if (window.event.keyCode == 13){
				search_free();
			}
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
						<div style="text-align:right;padding-bottom:10px">							
								<select name="sorting" id="sorting">
									<option value="0" selected>최신순</option>
									<option value="1">인기순</option>
								</select> 
						</div>
						<c:if test="${not empty loginUserInfo}">
							<div class="btn-new">
								<input type="button" onclick="write_new()" value="글쓰기">
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
								<c:forEach var="item" items="${result}">
									<!--  forEach로 데이터베이스가져오기 -->
									<c:set var="cnt" value="${cnt+1 }" />
									<div class="divTableRow">
										<div class="divTableCell">${cnt}</div>
										<div class="divTableCell">
											<a href="${root }board/free_board_read?free_idx=${item.free_idx}">${item.free_title}
												<c:if test="${item.free_comment_cnt != 0 }">
												<span style="color: #DF013A;font-size:10px;">[${item.free_comment_cnt}]</span>
												</c:if>
											</a>
										</div>
										<div class="divTableCell">${item.free_writer_name }</div>
										<div class="divTableCell">${item.free_date }</div>
									</div>
								</c:forEach>
							</div>
						</div>

						<div class="search_end">검색 결과 끝.</div>
						
						<div class="free_search">
							<div>
								검색조건
								<select name="condition" id="condition">
									<option value="0" selected>제목</option>
									<option value="1">내용</option>
									<option value="2">제목+내용</option>
									<option value="3">관리자</option>
								</select> 
								<input type="text" name="srch_f" id="srch_f" size="10" onkeyup="enterkey_3()" placeholder="검색어 입력">
								<input type="button" value="검색" onclick="search_free()"/>
							</div>
						
						</div>
					</div>


				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

	</div>
	<!--  -->