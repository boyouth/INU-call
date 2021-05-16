<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성하기</title>
</head>
<body>
<div class="list_title">
    <div class="tit">컴퓨터공학부 전화번호 모음입니다.</div>
    <div class="hit"></div>
    <div class="date"></div>
</div>
<hr style="border:1px color=silver;">
<div class="note">
    <div>작성자의 착오로 잘못된 전화번호가 등록되었다면 문의게시판에 남겨주세요.</div>
    <div>본인의 글은 <span style="color:red;">직접 삭제</span>가 가능합니다.</div>
</div>

<div class="list_content">
    <div>교무 및 학사지원 - 수업관련, 학적사항관련</div>
    <div>032-835-8929</div>

    <div>대학원 및 학생지원 - 장학금관련, 대학원관련(현장실습포함)</div>
    <div>032-835-8961</div>

    <div>시설지원 - 정보대 건물 강의실, 실습실, 자료, 기기들 관련</div>
    <div>032-835-8870</div>

    <div>캡스톤 - 졸업작품 관련 전체</div>
    <div>032-835-8941</div>

</div>
<hr style="border:1px color=silver;">


<div class="btn-emotion">
    <input type="button" value="좋아요">
    <input type="button" value="친절해요">
    <input type="button" value="불친절해요">
</div>

<hr>
<div class="list_comment">
    <div class="comment-img"><img src="https://img.icons8.com/small/16/000000/topic--v1.png" /></div>
    <div class="user_name">젤리</div>
    <div class="reply">친절하세요.</div>
</div>
<div class="list_comment_write">
    <div><textarea id="comment" name="comment" rows="2" cols=60> 
    </textarea></div>
    <div class="btn-comment"><input type="button" value="작성하기"></div>
</div>
</body>
</html>